import { Router } from "express";
import { controller } from "../controllers/wordle";

const routes = Router();

// Params:
// startDate: String(YYYY-MM-DD)
// endDate: String(YYYY-MM-DD)
routes.post("/helloWordle", controller);

export default routes;
