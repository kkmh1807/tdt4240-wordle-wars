import { Request, Response } from "express";
import { Word } from "../models/words";

function getRandomInt(max: number) {
  return Math.floor(Math.random() * max);
}

export const getRandomWord = async (req: Request, res: Response) => {
  const wordCount = await Word.countDocuments();
  const randomWordIndex = getRandomInt(wordCount);
  return res.status(200).json({ word: randomWordIndex });
};

export const guessWord = async (req: Request, res: Response) => {
  let validWord = true;
  const { guess, wordIndex } = req.body;
  const findValidWord = await Word.find({ word: guess });
  if (findValidWord.length < 1) {
    return res.status(200).json({ letters: null, validWord: false });
  }

  const word = (await Word.find().skip(wordIndex).limit(1))[0].word;
  let wordWithoutCorrect = word;

  const result = [];

  for (let i = 0; i < word.length; i++) {
    if (word[i] === guess[i]) {
      // Remove correct guesses to avoid wrong feedback when there is words with more instances of the same letter.
      // New word without correct guesses.
      for (let x = 0; x < wordWithoutCorrect.length; x++) {
        if (wordWithoutCorrect[x] == word[i]) {
          wordWithoutCorrect =
            wordWithoutCorrect.slice(0, x) + wordWithoutCorrect.slice(x + 1);
          break;
        }
      }

      result.push({
        letter: guess[i],
        status: 1,
        placement: 1,
      });
    } else {
      result.push({ letter: guess[i], status: 0, placement: 0 });
    }
  }

  // Check for correct letters with wrong placement after knowing which one has correct placement.
  for (let i = 0; i < word.length; i++) {
    if (word[i] !== guess[i]) {
      if (wordWithoutCorrect.includes(guess[i])) {
        result[i] = { letter: guess[i], status: 1, placement: 0 };

        for (let x = 0; x < wordWithoutCorrect.length; x++) {
          if (wordWithoutCorrect[x] == guess[i]) {
            wordWithoutCorrect =
              wordWithoutCorrect.slice(0, x) + wordWithoutCorrect.slice(x + 1);
            break;
          }
        }
      } else {
        result[i] = { letter: guess[i], status: 0, placement: 0 };
      }
    }
  }

  return res.status(200).json({
    letters: result,
    validWord: validWord,
  });
};
