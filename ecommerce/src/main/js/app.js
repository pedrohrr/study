'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {products: [], cartItens: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/products'}).done(response => {
			this.setState({products: response.entity});
		});
	}

	render() {
		return (
		    <div>
			    <ProductList products={this.state.products} updateCart={this.updateCart}/>
    		    //<CartList cartItens={this.state.cartItens} updateCart={this.updateCart}/>
            </div>
		)
	}

	updateCart(items) {
        console.log(items);
    }

}

class ProductList extends React.Component{
    render() {
        var products = this.props.products.map(product =>
            <Product key={product.id} product={product} updateCart={this.props.updateCart}/>
        );

        return (
            <table>
            <tbody>
            <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
            </tr>
            {products}
            </tbody>
            </table>
        )
    }
}

class CartList extends React.Component{
    render() {
        var cartItens = this.props.cartItens.map(item =>
            <CartItem key={item.product.id} item={item} updateCart={this.props.updateCart}/>
        );
        return (
            <table>
            <tbody>
            <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Action</th>
            </tr>
            {cartItens}
            </tbody>
            </table>
        )
    }
}

class Product extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.product.name}</td>
				<td>{this.props.product.price}</td>
				<td><AddButton product={this.props.product} updateCart={this.props.updateCart}/></td>
			</tr>
		)
	}
}

class CartItem extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.item.product.name}</td>
                <td>{this.props.item.quantity}</td>
                <td><RemoveButton item={this.props.item} updateCart={this.props.updateCart}/></td>
            </tr>
        )
    }
}

class AddButton extends React.Component{
    render() {
        return <button type="button" onClick={this.onClick.bind(this)}>Add</button>
    }

    onClick() {
    	var entity = { product: this.props.product.id, quantity: 1};
        client({
			method: 'POST',
			path: '/cart/products',
			entity: entity,
			headers: {'Content-Type': 'application/json'}
        }).done(response => {
            this.props.updateCart(response);
    	});
    }
}

class RemoveButton extends React.Component{
    render() {
        return <button type="button" onClick={this.onClick.bind(this)}>Remove</button>
    }

    onClick() {
        client({
            method: 'DELETE',
            path: '/cart/products/' + this.props.item.product.id
        }).done(response => {
            this.props.updateCart(response);
    });
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)