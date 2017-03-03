function add(n1, n2)
{
    return n1 + n2;
}

var sub = function(n1, n2)
{
    return n1 - n2;
};

var cb = function(n1, n2, callback)
{
    if(!(typeof n1 === "number" && typeof n2 === "number" && typeof callback === "function"))
    {
        throw Error("Illegal arguments in call to function + bingo");
    }
    return "Resultatet for " + n1 + " + " + n2 + " = " + callback(n1, n2);
};

try
{
    console.log(cb(1,1, function(n1, n2){return n1 / n2}));
    console.log( cb(4, bingo, add) );
    console.log( cb(4, 3, add) );
}
catch(err)
{
    console.log("Error: " + err.message)
}

console.log(typeof cb === "function");