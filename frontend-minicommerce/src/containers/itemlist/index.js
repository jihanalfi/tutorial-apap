import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import {Badge, Fab} from "@material-ui/core";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import PointOfSaleIcon from '@mui/icons-material/PointOfSale';
import Cart from "../../components/cart";


class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            cartItems: [],
            cartHidden: true,
            isLoading: false,
            isCreate: false,
            isEdit: false,
            isSearch: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            keywords: "",
            total:0
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearchItem = this.handleSearchItem.bind(this);
        // this.handleSearchSubmitItem = this.handleSearchSubmitItem(this);
    }
    componentDidMount() {
        this.loadData();
        console.log("componentDidMount()")
    }

    async loadData() {
        try {
            if(this.state.cartHidden){
                const {data} = await APIConfig.get("/item");
                this.setState({items: data.result});
            } else {
                const {data} = await APIConfig.get("/cart");
                this.setState({items: data.result});
            }
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }

    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()")
        return true
    }

    handleClickLoading(){
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleAddItem(){
        this.setState({isCreate: true});
    }

    handleCancel(event){
        event.preventDefault();
        this.setState({isCreate: false, isEdit: false});
    }

    handleChangeField(event){
        const {name, value} = event.target;
        this.setState({[name]: value});
    }

    async handleSubmitItem(event){
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleEditItem(item){
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async handleSubmitEditItem(event){
        event.preventDefault();
        try{
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSearchItem (event) {
        event.preventDefault();
        this.setState({isSearch: true})
         try {
            const keywords = event.target.value
            // console.log(event.target.value)
            const {data} = await APIConfig.get(`/item?title=${keywords}`)
            this.setState({items: data.result})
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
            this.handleCancel(event);
        }
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({cartHidden: !cartHidden });
    }

    handleSubmitItemToCart(item, total) {
        const newItems = [...this.state.cartItems];
        const newItem = {...item};
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        // let newBalance = this.state.balance;
        if (targetInd < 0) {
            // if (newBalance < newItem.price) {
            //     alert("Balance not sufficent!");
            //     return;
            // }
            newItem.inCart = true;
            newItems.push(newItem);
            this.updateShopItem(newItem, true);
            // newBalance = newBalance - newItem.price;
        }
        // this.setState({balance: newBalance});
        this.setState({cartItems: newItems });
    }


    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.items;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems [targetInd].inCart = inCart;
        this.setState({shopItems: tempShopItems });
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>All Items</h1>
                <div style={{position: "fixed", top: 25, right: 25}}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                            : <PointOfSaleIcon/>
                            }
                    </Fab>
                </div>
                <div className="row mt-3">
                    {!this.state.cartHidden ? (
                            <div className="row mt-3">
                                <div>
                                    {this.state.items.map((cart) => (
                                        <Cart
                                              id={cart.id}
                                              title={cart.title}
                                              price={cart.price}
                                              description={cart.description}
                                              category={cart.category}
                                              totalPrice={cart.total*cart.price}
                                            // onItemClick={this.handleDeleteItemInCart}
                                            // isShopList={false}
                                        >
                                        </Cart>
                                    ))}
                                </div>

                            </div>

                        ):
                        <div className="row mt-3">
                            <input
                                show={this.state.cartItems}
                                className={classes.textField}
                                type="text"
                                name="keywords"
                                value={this.state.keywords}
                                onChange={this.handleChangeField}
                                onKeyPress={event => {
                                    if (event.key === 'Enter') {this.handleSearchItem(event)}
                                }}
                            >
                            </input>
                            <Button
                                action={this.handleAddItem}>
                                Add Item
                            </Button>
                            <div>
                                {this.state.items.map((item) => (
                                    <Item
                                        key={item.id}
                                        id={item.id}
                                        title={item.title}
                                        price={item.price}
                                        description={item.description}
                                        category={item.category}
                                        quantity={item.quantity}
                                        total={item.total}
                                        handleEdit={() => this.handleEditItem(item)}
                                        handleToCart={() => this.handleSubmitItemToCart(item, item.total)}
                                    />
                                ))}
                            </div>
                            <Modal
                                show={this.state.isCreate || this.state.isEdit}
                                handleCloseModal={this.handleCancel}
                                modalTitle={this.state.isCreate ? "Add Item" : `Edit item ID ${this.state.id}`}
                            >
                                <form>
                                    <input
                                        className={classes.textField}
                                        type="text"
                                        placeholder="Nama Item"
                                        name="title"
                                        value={this.state.title}
                                        onChange={this.handleChangeField}
                                    />
                                    <input
                                        className={classes.textField}
                                        type="number"
                                        placeholder="Harga"
                                        name="price"
                                        value={this.state.price}
                                        onChange={this.handleChangeField}
                                    />
                                    <textarea
                                        className={classes.textField}
                                        placeholder="Deskripsi"
                                        name="description"
                                        rows="4"
                                        value={this.state.description}
                                        onChange={this.handleChangeField}
                                    />
                                    <input
                                        className={classes.textField}
                                        type="text"
                                        placeholder="Kategori"
                                        name="category"
                                        value={this.state.category}
                                        onChange={this.handleChangeField}
                                    />

                                    <input
                                        className={classes.textField}
                                        type="number"
                                        placeholder="qty"
                                        name="quantity"
                                        value={this.state.quantity}
                                        onChange={this.handleChangeField}
                                    />

                                    <Button action={this.state.isCreate?
                                        this.handleSubmitItem : this.handleSubmitEditItem}>
                                        Create
                                    </Button>
                                    <Button action={this.handleCancel}>
                                        Cancel
                                    </Button>
                                </form>

                            </Modal>
                        </div>

                    }

                </div>

            </div>
        );
    }

}
export default ItemList;
