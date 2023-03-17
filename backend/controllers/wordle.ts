import { Request, Response } from "express";

export const controller = (req: Request, res: Response) => {
  return res.status(200).json({ status: "ok" });
};
