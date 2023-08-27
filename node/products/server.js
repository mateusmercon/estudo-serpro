import { configDotenv } from "dotenv"
import express from "express"
import mongoose from "mongoose";
import productRoute from "./routes/productRoute.js"

configDotenv();
const PORT = process.env.PORT
const MONGO_DB = process.env.MONGO_DB

const app = express()
app.use(express.json(), productRoute)

app.get("/", (req, res) => { res.send("Products API Home Page") })

mongoose
    .connect(MONGO_DB)
    .then(() => {
        console.log("Sucessfully connected on database")
        app.listen(PORT, () => { console.log(`Server is running on port ${PORT}`) })
    })
    .catch ((error) => {
        console.log(error)
    })
