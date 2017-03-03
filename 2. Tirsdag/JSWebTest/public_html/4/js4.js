var names = [];

var prepareNames = function()
{
    var ul = document.getElementById("names");
    var tempNames = ul.getElementsByTagName("li");
    for(var i = 0; i < tempNames.length; i++)
    {
        names.push(tempNames[i].innerText);
    }
    console.log(names);
};

var addName = function()
{
    var nytNavn = document.getElementById("nytNavn").value;
    names.push(nytNavn);
    document.getElementById("names").innerHTML += "<li> "+ nytNavn + "</li>";
};

var removeFirst = function()
{
    names.splice(0, 1);
    updateNames();
};

var removeLast = function()
{
    names.splice(names.length-1);
    updateNames();
};

var updateNames = function()
{
    var ul = document.getElementById("names");
    ul.innerHTML = "";
    for(var i = 0; i < names.length; i++)
    {
        ul.innerHTML += "<li> "+ names[i] + "</li>";
    }
};

