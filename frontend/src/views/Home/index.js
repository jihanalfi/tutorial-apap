import React from 'react';
import listItems from "../../items.json";
import List from "../../components/List/index" ;
import "./index.css" ;
import {Badge, Fab} from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';



export default class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }

    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = {...item};
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        let oldBalance = this.state.balance;
        let newBalance;
        if (targetInd < 0) {
            newBalance = oldBalance - newItem.price;
            if(newBalance > 0){
                newItem.inCart = true;
                newItems.push(newItem);
                this.updateShopItem(newItem, true);
            } else {
                alert("Balance not sufficient!");
                newBalance = oldBalance;
            }

        }
        this.setState({cartItems: newItems });
        this.setState({balance: newBalance});
    }

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({shopItems: tempShopItems });
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({cartHidden: !cartHidden });
    }

    handleDeleteItemInCart = (item) => {
        const itemUsed = {...item};
        const items = [...this.state.cartItems];
        const newList = items.filter((item) => item.id !== itemUsed.id);
        itemUsed.inCart = false;
        let oldBalance = this.state.balance;
        let newBalance;
        newBalance = oldBalance + itemUsed.price;

        this.updateShopItem(item,  false);
        this.setState({cartItems: newList});
        this.setState({balance: newBalance});
    }


    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{position: "fixed", top: 25, right: 25}}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                            : <ViewStreamIcon/>}
                    </Fab>
                </div>

                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>

                <p className="text-center text-primary">Your Balance: <b> {this.state.balance}</b></p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List title="My Cart"
                                      items={this.state.cartItems}
                                      onItemClick={this.handleDeleteItemInCart}
                                      // isShopList={false}
                                >
                                </List>
                            </div>
                        ) :
                            <div className="col-sm">
                                <List
                                    title="List Items"
                                    items={listItems}
                                    onItemClick={this.handleAddItemToCart}
                                    isShopList={true}
                                ></List>
                            </div>
                        }

                    </div>
                </div>
            </div>
        );
    }
}
