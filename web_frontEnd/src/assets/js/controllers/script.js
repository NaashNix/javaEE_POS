// var z = jQuery.noConflict();
initializer()
$("#POSDashboard").css("display", "none");
$("#posButton").attr("class", "nav-link active");
$("#pos_dashboard_menu").css("display", "none");


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
    var data = $("#loginForm").serialize();
    console.log("DATA of the table : ", data);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/webpos/login",
        data: data,
        success: function (response) {
            if (response == 'true') {
                redirectToDashboard();
            }
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
    // z(container+" div").css("display","none");
    // document.getElementById("customerNameContainer").parentNode.removeChild("div");
}


// function dashboardClick(){
//     initializer();
//     document.getElementById("dashboard").style.display="block";
//     document.getElementById("dashboard-button").setAttribute("class","nav-link active");
// }

// function stockClick(){
//     initializer();
//     document.getElementById("stock").style.display="block";
//     document.getElementById("stock-button").setAttribute("class","nav-link active");
// }

// function transactionClick(){

// }

// function addToCartClick(){
//     document.getElementById("grandTotal").innerText="RS. 750.00";
//     totalChange();
// }

// function totalChange(){
//     console.log("total changed");
//     document.getElementById("payButton").innerText+=" ("+document.getElementById("grandTotal").innerText+")"
// }

// // Customer Table adding when click the save button.
// function addCustomerDataToTable(){

//     $("#customerTable tr").off('click');

//     var name = $("#customerName").val();
//     var code = $("#customerCode").text();
//     var nic = $("#customerNic").val();
//     var tel = $("#customerTel").val();

//     console.log(name+" "+code+" "+nic+" "+tel); 

//     $("tbody").append(
//         "<tr>" + 
//         "<th scope=\"row\">"+ code +"</th>" + 
//         "<td>" + name + "</td>"  + 
//         "<td>" + nic + "</td>" + 
//         "<td>" + tel + "</td>"  +
//         "</tr>"
//     );


//     $("#customerTable tr").click(function () {
//         let custId = $(this).children(":eq(0)").text();
//         let custName = $(this).children(":eq(1)").text();
//         let custAddress = $(this).children(":eq(2)").text();
//         let custTp = $(this).children(":eq(3)").text();

//         console.log(custId, custName, custAddress, custTp);
//     });

// }   

// $("#customerTable tr").click(function () {
//     let custId = $(this).children(":eq(0)").text();
//     let custName = $(this).children(":eq(1)").text();
//     let custAddress = $(this).children(":eq(2)").text();
//     let custTp = $(this).children(":eq(3)").text();

//     console.log(custId, custName, custAddress, custTp);
// }); 

// var customerDB;
// var customerObject;

// $("#customerSave").click(function(){
//     customerObject = 
//     customerDB.unshift()
// })


// ------------------------------

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
            let customer = {
                id: $("#generatedCustomerId").text(),
                name: $("#customerName").val(),
                address: $("#customerAddress").val(),
                telephone: $("#customerTelephone").val(),
                email: $("#customerEmail").val(),
                account: "Gold"
            };

            customers.push(customer);
            loadAllCustomers();
        }
    }

    console.log(customers[0].name);
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

loadAllCustomers();

function loadAllCustomers() {
    // customers.forEach(element => {
    //     if (element == null) {
    //         console.log("Loaded But Null");
    //         return;
    //     } else {
    //         console.log("Loaded");
    //         let cName = element.name;
    //         let cAddress = element.address;
    //         let cId = element.id;
    //         let cEmail = element.email;
    //         let cTelephone = element.telephone;
    //         z("#customerDetailsTable>tbody").append(
    //             "<tr>" +
    //     "<th scope=\"row\">"+ cId +"</th>" +
    //     "<td>" + cName + "</td>"  +
    //     "<td>" + cTelephone + "</td>" +
    //     "<td>" + cAddress + "</td>"  +
    //     "<td>" + 5 + "</td>"  +
    //     "<td>" + null + "</td>"  +
    //     "</tr>"
    //         );
    //     }
    // });
}

