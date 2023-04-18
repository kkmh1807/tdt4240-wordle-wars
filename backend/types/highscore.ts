export interface HighscoreType extends Document {
    username: string; 
    score: Number; 
  }

  export type ResponseHighscoreType = {
    username: string; 
    score: Number; 
  }