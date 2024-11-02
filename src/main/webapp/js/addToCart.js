let cart = [];
// Hàm thêm món vào giỏ hàng
function addToCart(id, name, price) {

    const item = {
        id: parseInt(id),
        name: name,
        price: parseInt(price),
        quantity: 1
    };
    const existingItem = cart.find(cartItem => cartItem.name === name);
    if (existingItem) {
        existingItem.quantity += 1;  // Tăng số lượng
    } else {
        cart.push(item);
    }

    renderCart();
}
function renderCart() {
    const cartItemsDiv = document.getElementById("cart-dishes");
    const cartTotalDiv = document.getElementById("total");
    cartItemsDiv.innerHTML = "";
    let Total = 0;
    cartTotalDiv.innerHTML = `<span>Total = ${Total} VND</span>`;
    
    cart.forEach((item, index) => {
        const innerHTML = `
            <div class="cart-dish">
                <div class="cart-dish-img">
                    <img src="${contextPath}/img/dish-${item.id}.jpg" alt="${item.name}">
                </div>
                
                <div class="cart-dish-inf">
                    
                    <span>${item.name}</span>
                    <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${index}, this.value)">
                    <span>${item.quantity * item.price} VND</span>
                </div>
                <div class="cart-dish-remove">
                    <button onclick="removeFromCart(${index})">Remove</button>
                </div>
            </div>
        `;
        cartItemsDiv.innerHTML += innerHTML;
        Total += item.quantity * item.price;
        
    });
    cartTotalDiv.innerHTML = `<span>Total = ${Total} VND</span>`;
}



// Hàm cập nhật số lượng
function updateQuantity(index, quantity) {
    cart[index].quantity = parseInt(quantity);
    renderCart();
}

// Hàm xóa món khỏi giỏ hàng
function removeFromCart(index) {
    cart.splice(index, 1);  // Xóa 1 phần tử tại vị trí index
    renderCart();
}

// Hàm lưu đơn hàng
function saveOrder() {
    // Chuyển giỏ hàng thành JSON để gửi về server
    const order = JSON.stringify(cart);
    alert("Đơn hàng đã được lưu: " + order);

    // Ở đây bạn có thể dùng AJAX để gửi đơn hàng về server
}