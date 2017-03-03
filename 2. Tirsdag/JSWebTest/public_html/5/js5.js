var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

var getFormattedTable = function(carArr)
{
    if(carArr == null)
    {
        carArr = cars;
    }
    var formatted = "";
    for(var i = 0; i < carArr.length; i++)
    {
        formatted +=
                ("<tr><td>" + carArr[i].id + "</td>" +
                "<td>" + carArr[i].year + "</td>" +
                "<td>" + carArr[i].make + "</td>" +
                "<td>" + carArr[i].model + "</td>" +
                "<td>" + carArr[i].price + "</td></tr>");
    };
    return formatted;
};

var updateTable = function()
{
    var table = document.getElementById("tableBody");
    table.innerHTML = getFormattedTable();
};

var sortTable = function(sortPrice)
{
    if (sortPrice === "")
    {
        sortPrice = 999999;
    }
    var sortedTable = [];
    for(var i = 0; i < cars.length; i++)
    {
        if(cars[i].price <= sortPrice)
        {
            sortedTable.push(cars[i]);
        }
    }
    var table = document.getElementById("tableBody");
    table.innerHTML = getFormattedTable(sortedTable);
};