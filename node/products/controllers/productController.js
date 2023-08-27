import Product from "../models/productModel.js";

export const getProducts = async (req, res) => {
    try {
        const products = await Product.find()
        res.status(200).json(products)
    } catch (error) {
        console.log(error)
    }
}

export const saveProduct = async (req, res) => {
    try {
        const product = await Product.create(req.body)
        res.status(201).json(product)
    } catch (error) {
        console.log(error)
    }
}

export const getProductById = async (req, res) => {
    try {
        const id = req.params.id
        const product = await Product.findById(id)
        if (!product) {
            res.status(404);
            throw new Error(`cannot find any product with ID ${id}`);
        }
        res.status(200).json(product)
    } catch (error) {
        console.log(error)
    }
}

export const updateProduct = async (req, res) => {
    try {
        const id = req.params.id
        const product = await Product.findByIdAndUpdate(id, req.body)
        if (!product) {
            res.status(404);
            throw new Error(`Cannot find product with ID: ${id}`);
        }
        const newProduct = await Product.findById(id)
        res.status(200).json(newProduct)
    } catch (error) {
        console.log(error)
    }
}

export const deleteProduct = async (req, res) => {
    try {
        const id = req.params.id
        const product = await Product.findByIdAndDelete(id)
        if (!product) {
            res.status(404);
            throw new Error(`Cannot find product with ID: ${id}`);
        }
        const newProduct = await Product.findById(id)
        res.status(200).json(newProduct)
    } catch (error) {
        console.log(error)
    }

}

