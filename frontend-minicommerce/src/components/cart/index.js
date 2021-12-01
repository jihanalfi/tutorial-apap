import React from "react";
import classes from "../Item/styles.module.css";
import Item from "../Item";

const Cart = (props) => {
    const { id, handleEdit, total, handleDelete, totalPrice} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID Cart ${id}`}</h3>
            <p>{`Nama Barang: ${Item.title}`}</p>
            <p>{`Harga: ${Item.price}`}</p>
            <p>{`Jumlah: ${total}`}</p>
            <p>{`Deskripsi: ${Item.description}`}</p>
            <p>{`Kategori: ${Item.category}`}</p>
            <p><strong>{`Total Harga: ${totalPrice}`}</strong></p>

        </div>
    );
};

export default Cart
