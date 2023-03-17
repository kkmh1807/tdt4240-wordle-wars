import { Router } from "express";

const routes = Router();

// Params:
// startDate: String(YYYY-MM-DD)
// endDate: String(YYYY-MM-DD)
routes.post("/helloWordle");

export default routes;
