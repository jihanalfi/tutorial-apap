import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Index = (props) => {
    const { id, title, price, description, category, handleEdit, quantity, total, handleDelete, handleToCart} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            <Button action={handleDelete}>
                Delete
            </Button>
            <br/>
            <form><input name="total"></input> <Button action={handleToCart}>Add to Cart</Button></form>

        </div>
    );
};
export default Index;