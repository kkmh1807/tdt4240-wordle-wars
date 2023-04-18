import { model, Schema } from "mongoose";
import { HighscoreType } from "../types/highscore";

const highscoreSchema = new Schema<HighscoreType>(
  {
    username: {
      type: String,
      required: true,
    },
    score: {
        type: Number,
        required: true,
      },
  },
  { collection: "highscore" }
);

const Highscore = model<HighscoreType>("Highscore", highscoreSchema);

export { Highscore };