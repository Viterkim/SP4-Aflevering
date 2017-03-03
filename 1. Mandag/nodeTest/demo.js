var names = [ {firstName: "Håndbold", lastName: "Fuglen"}, {firstName: "Bingo", lastName: "Trolden"} ];
names.phone = "7777777"; // Doesn't work 

console.log(names[1].lastName, names[0].phone);

function nameFactory()
{
    return {firstName: "Cirkus", lastName: "Jøden"};
}

var n = nameFactory();

for(prop in n)
{
    console.log(prop, n[prop]);
}
n.phone = "85858585";
console.log(n.firstName, n.lastName, n.phone);
