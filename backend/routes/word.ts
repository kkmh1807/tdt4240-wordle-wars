import { Router } from "express";
import { getRandomWord, guessWord } from "../controllers/wordle";

const wordRoutes = Router();

// @returns {word: number}
wordRoutes.get("/", getRandomWord);

// @param {word: number}
// @param {guess: string}
// @returns {validWord: boolean, letters {"letter": string, status: number, placement: number}}
wordRoutes.post("/guess", guessWord);

export default wordRoutes;
