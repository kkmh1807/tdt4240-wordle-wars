import { model, Schema } from "mongoose";
import { WordType } from "../types/words";

const wordSchema = new Schema<WordType>(
  {
    word: {
      type: String,
      required: true,
    },
  },
  { collection: "words" }
);

const Word = model<WordType>("Word", wordSchema);

export { Word };
