// var z = jQuery.noConflict();
initializer()
$("#POSDashboard").css("display", "none");
$("#posButton").attr("class", "nav-link active");
$("#pos_dashboard_menu").css("display", "none");

// Function for the menu.



function initializer() {
    document.getElementById("customerPage").style.display = "none";
    document.getElementById("itemListPage").style.display = "none";
    // document.getElementById("sample").style.display="none";
    document.getElementById("POSDashboard").style.display = "none";
    document.getElementById("posButton").setAttribute("class", "nav-link");
    document.getElementById("customerButton").setAttribute("class", "nav-link");
    document.getElementById("reportButton").setAttribute("class", "nav-link");
    document.getElementById("stockButton").setAttribute("class", "nav-link");
}

function customerClicked() {
    initializer();
    loadAllCustomers();
    getLastCustomerId();
    document.getElementById("customerPage").style.display = "block";
    document.getElementById("customerButton").setAttribute("class", "nav-link active");
}

function posClicked() {
    initializer();
    document.getElementById("POSDashboard").style.display = "block";
    document.getElementById("posButton").setAttribute("class", "nav-link active");
}

function stockClicked() {
    initializer();
    document.getElementById("itemListPage").style.display = "block";
    document.getElementById("stockButton").setAttribute("class", "nav-link active");
}

function reportClicked() {
    // initializer();
    // document.getElementById("sample").style.display="block";
    // document.getElementById("reportButton").setAttribute("class","nav-link active");
}

// Listener for login button.

var usernameFiled = document.querySelector("#usernameField");
var passwordField = document.querySelector("#passwordField");

usernameFiled.addEventListener("keypress", (event) => {
    if (event.keyCode === 13) {
        event.preventDefault();

        loginButtonClicked();
    }
});

passwordField.addEventListener("keypress", (event) => {
    if (event.keyCode === 13) {
        event.preventDefault();

        loginButtonClicked();

    }
});

function customerFormValidation() {
    const customerName = "([A-z])\w+"
    const customerAddress = "^[a-zA-Z0-9\s,'/-]*$"
    const email = "/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/</>"

    const cName = $("#customerName").val();

    if (cName.match(cName)) {
        // z("#customerName").css({ 'border': '1px solid white' });
        resetInputs("#customerName", "#customerNameContainer");
    } else {
        $("#customerName").css({
            'border-bottom': '2px solid #FFCC00'
        });
    }

}


function loginButtonClicked() {
    // var data = $("#loginForm").serialize();
    // console.log("DATA of the table : ", data);
    // $.ajax({
    //     type: "POST",
    //     url: "http://localhost:8080/webpos/login",
    //     data: data,
    //     success: function (response) {
    //         if (response == 'true') {
    //             redirectToDashboard();
    //         }
    //     }
    // });
    redirectToDashboard();
}

$("#addCustomerButton").click(function (e) { 
    // e.preventDefault();
    getLastCustomerId();    
});


function loadCustomerDetails(){
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/webpos/customer?option=SEARCH&requestedID=${$("#searchCustomerField").val()}`,
        dataType: "json",
        
        success: function (response) {
            
            console.log("Response",response.data.name);
            $("#customerNameField").val(response.data.name);
            $("#customerTelFiled").val(response.data.telephone);

        
        },
        error : function (ob,state) {
            console.log("Error",ob,state);
          }
    });
}

function getLastCustomerId(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/webpos/customer?option=GETID",
        // dataType: "text",
        success: function (response) {
            var lastId = response;
            $("#generatedCustomerCode").text(lastId);
            console.log("Next Customer Id : ",response);
        }
    });
}


function redirectToDashboard() {
    $("#pos_dashboard_menu").css("display", "block");
    $("#loginScreen").css("display", "none");
    $("#POSDashboard").css("display", "block");
}

function sayWarning(id, container) {
    $(id).css({ 'border-bottom': '2px solid red' });
    // z(container).append('<div class="red-warning"><span style="font-weight: 800; ">!</span></div>');
    // z(id.css('display','block'));
    $(id + " div:nth-child(2)").css('display', 'block');
    // console.log();
}

function resetInputs(id, container) {
    $(id).css({
        'border': '1px solid white'
    });

    var obj = $("container div");
    obj.remove();
    
}



function customerSave() {
    var noProblem = false; // This false = no problem. if true there is problem.
    {
        if ($("#customerName").val() == "") {
            alert("Please Enter Valid Name");
            sayWarning("#customerName", "#customerNameContainer");

        } else {
            console.log("Warning Removed");
            resetInputs("#customerName", "#customerNameContainer");
        }

        if ($("#customerAddress").val() == "") {
            console.log("Please Enter Customer Address");

        } else {
            resetInputs("#customerAddress");
        }

        if ($("#customerTelephone").val() === "") {
            console.log("Please Enter Telephone Number");
        }
        if ($("#customerEmail").val() == "") {
            console.log("Please Enter Customer Email");
        }
        if (!noProblem) {
            console.log("No Problem");

            // Making data object to send.
            var newCustomerInfo = {
                customerId: $("#generatedCustomerCode").text(),
                customerName: $("#customerName").val(),
                customerTelephone: $("#customerTelephone").val(),
                customerAddress: $("#customerAddress").val()
            }

            // Saving Customer, Sending data to the servlet.
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/webpos/customer",
                data: newCustomerInfo,
                dataType: "application/json",
                success: function (response) {
                    console.log("Response", response);
                }
            });

            // customers.push(customer);
            loadAllCustomers();
        }
    }

    // console.log(customers[0].name);
}

function clearCustomerAddForm() {
    console.log("Cleared");
    $("#customerEmail").val("");
    $("#customerAddress").val("");
    $("#customerTelephone").val("");
    $("#customerName").val("");
}


function saveItem() {
    let newItem = {
        itemName: $("#itemName").val(),
        amount: $("#amountOfItem").val(),
        price: $("#price").val(),
        batchNumber: $("#batchNumber").val(),
        expireDate: $("#expireDate").val(),
        mfd: $("#mfd").val()
    };

    items.push(newItem);
    console.log(items[0].itemName);
}


function loadAllCustomers() {
    
    $("#customerTableBody").empty();
    console.log("LoadAllCustomers method fired.");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/webpos/customer?option=GETALL",
        dataType: "json",

        success: function (resp) {
            for (const customer of resp.data) {
                console.log("Customer : ", resp.name);
                let row = `<tr><td>${customer.id}</td><td>${customer.name}</td><td>${customer.telephone}</td><td>${customer.address}</td><td></td><td></td></tr>`;
                $("#customerTableBody").append(row);
            }
        },
        error: function (ob, state) {
            console.log(ob, state)
        }
    });

}



// Here goes the dashboard js functions.
let selectedItem;

function searchItem(){
    console.log("Item Code : ",$("#itemSearchField").val());
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/webpos/item?option=SEARCH&requestedId=${$("#itemSearchField").val()}`,
        dataType: "json",
        success: function (response) {
            if (response.data != null){

                selectedItem = {
                    id: response.data.id,
                    name: response.data.itemName,
                    inStock: response.data.inStock,
                    unitPrice : response.data.unitPrice,


                };

                $("#exdField").val(response.data.exd);
                $("#mfdField").val(response.data.mfd);
                $("#batchNumberField").val(response.data.batchNumber);
                $("#itemNameField").text(response.data.itemName);            
            }

        }
    });
}

function calculateItemPrice(requestedAmount){
    
    var itemPriceField = $("#itemPriceField");
    let unitPrice = selectedItem.unitPrice;
    let itemPrice = requestedAmount * unitPrice;
    itemPriceField.text(itemPrice.toFixed(2));

}

function plusButtonClicked(){
    console.log("SelectedItm.inStock",selectedItem.inStock);
    var inStockQuantity = selectedItem.inStock;
    let requestedAmount = $("#requestedAmount").val();
    if(requestedAmount == ''){
        requestedAmount = 0;
    }
    requestedAmount = Number(requestedAmount);

    if(inStockQuantity <= requestedAmount){
        console.log("inStockQuantity < requestedAmount");
        alert("Stock Over!")
    }else{
        console.log("inStockQuantity > requestedAmount");
        requestedAmount = requestedAmount+1;
        $("#requestedAmount").val(requestedAmount);
        calculateItemPrice(requestedAmount);

    }

    
}

function minusButtonClicked(){
    let inStockQuantity = selectedItem.inStock;
    let requestedAmount = $('#requestedAmount').val();
    if(requestedAmount === '' || requestedAmount === undefined){
        // Here goes the error message for no amount.
    }

    if(requestedAmount > 0){
        requestedAmount = Number(requestedAmount);
        requestedAmount = requestedAmount-1;
        $("#requestedAmount").val(requestedAmount);
        calculateItemPrice(requestedAmount);
    }else{
        alert("Requested Amount is 0");

    }

    
}

let cartArray = [];

function addToCartButtonClick(){
    let itemPrice = Number($("#itemPriceField").text());
    let reqQuantity = Number($("#requestedAmount").val());
    let itemToAddCart = { 
        id : selectedItem.id,
        name : selectedItem.name,
        price : itemPrice,
        reqQuantity : reqQuantity
    }

    for (let i = 0; i < cartArray.length; i++) {
        if (itemToAddCart.id === cartArray[i].id){

            cartArray[i] = {
                id: cartArray[i].id,
                name: cartArray[i].name,
                price: (itemToAddCart.price + cartArray[i].price),
                reqQuantity: itemToAddCart.reqQuantity + cartArray[i].reqQuantity
            };
            updateCart();
            return;
        }
    }


    cartArray.push(itemToAddCart);
    updateCart();

}

function updateCart(){
    console.log("updateCartMethod");
    $("#cartTableBody").empty();
    cartArray.forEach(element => {
        $("#cartTableBody").append(
            `<tr>
             <th>${element.id}</th>
             <td>${element.name}</td>
             <td>${element.reqQuantity}</td>
             <td>${element.price}</td>
            </tr>`
        );
    });
}