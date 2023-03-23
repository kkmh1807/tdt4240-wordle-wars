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

  const result = [];

  for (let i = 0; i < word.length; i++) {
    if (word[i] == guess[i]) {
      result.push({
        letter: guess[i],
        status: 1,
        placement: 1,
      });
    } else if (word.includes(guess[i])) {
      result.push({ letter: guess[i], status: 1, placement: 0 });
    } else {
      result.push({ letter: guess[i], status: 0, placement: 0 });
    }
  }

  return res.status(200).json({
    letters: result,
    validWord: validWord,
  });
};
