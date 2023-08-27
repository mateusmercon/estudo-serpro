import { getProducts, getProductById, saveProduct, updateProduct, deleteProduct } from "../controllers/ProductController.js";
import express from "express"

const router = express.Router()

router.get("/get-products", getProducts)
router.get("/get-product/:id", getProductById)
router.post("/save-product", saveProduct)
router.put("/update-product/:id", updateProduct)
router.delete("/delete-product/:id", deleteProduct)

export default router