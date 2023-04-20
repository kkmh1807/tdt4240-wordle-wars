import { Request, Response } from "express";
import { Highscore } from "../models/highscore";
import { ResponseHighscoreType } from "../types/highscore";

export const getHighscore = async (req: Request, res: Response) => {
  const importHighscoreList = await Highscore.find()
    .limit(10)
    .sort({ score: -1, username: 1 });

  let highscoreList: ResponseHighscoreType[] = [];

  importHighscoreList.forEach(function (highscore) {
    const newResponseHighscore: ResponseHighscoreType = {
      username: highscore.username,
      score: highscore.score,
    };
    highscoreList.push(newResponseHighscore);
  });

  return res.status(200).json(highscoreList);
};

export const addHighscore = async (req: Request, res: Response) => {
  const username = req.body.username;
  const score = req.body.score;

  if (!username) {
    return res.status(400).json({ message: "Missing username" });
  }

  if (!score) {
    return res.status(400).json({ message: "Missing score" });
  } else if (!Number.isInteger(score)) {
    return res.status(400).json({ message: "Score is wrong type" });
  }

  const newHighscore = new Highscore({
    username: username,
    score: score,
  });

  const feedback = await Highscore.create(newHighscore);

  if (feedback.id) {
    const importHighscoreList = await Highscore.find()
      .limit(10)
      .sort({ score: -1, username: 1 });

    let highscoreList: ResponseHighscoreType[] = [];

    importHighscoreList.forEach(function (highscore) {
      const newResponseHighscore: ResponseHighscoreType = {
        username: highscore.username,
        score: highscore.score,
      };
      highscoreList.push(newResponseHighscore);
    });

    return res.status(200).json(highscoreList);
  } else {
    return res.status(400).json({ message: "Something went wrong" });
  }
};
