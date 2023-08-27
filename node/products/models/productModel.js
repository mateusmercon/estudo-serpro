import mongoose from "mongoose"
import { v4 as uuid } from "uuid"

const productSchema = mongoose.Schema(
    {
        id: {
            type: String,
            default: uuid(),
            required: false
        },
        name: {
            type: String,
            required: false
        },
        price: {
            type: Number,
            required: false
        },
        quantity: {
            type: Number,
            required: false,
            default: 1
        }
    },
    {
        timestamps: true
    }
)

const Product = mongoose.model("Product", productSchema)

export default Product;