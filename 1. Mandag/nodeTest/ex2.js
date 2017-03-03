var names = ["Håndboldfuglen", "85 Slangen", "Bingotrolden", "Cirkus Jøden", "HalloManden"];

//for (var i = 0; i < names.length; i++)
//{
//    console.log(names[i]);
//}

names.forEach(function(name)
{
    console.log(name)
});

//Filtrerer og findet med ting der starter med H
var filtered = names.filter(function(name)
{
    return name[0]==="H";
});
console.log(filtered);

setTimeout(function()
{
    console.log("Hva så brormand");
}, 1000);

names = names.map(function(name) // Map creates a new array and calls a function(callback) on every element
{
    return "<li>" + name + "</li>";
});

var listItems = "<ul>" + names.join(""); + "</ul>"
console.log(listItems);