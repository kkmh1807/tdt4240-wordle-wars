import { Router } from "express";
import { addHighscore, getHighscore } from "../controllers/highscore";

const highscoreRoutes = Router();

// @returns {username: string, score: number}[]
highscoreRoutes.get("/", getHighscore);

// @param {username: string}
// @param {score: number}
// @returns {username: string, score: number}[]
highscoreRoutes.post("/add", addHighscore);

export default highscoreRoutes;
