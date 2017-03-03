var myFunc = function()
{
    var outer = document.getElementById("outer");
    outer.addEventListener("click", function(event)
    {
        var pid = document.getElementById("pid");
        var target = event.target;
        pid.innerHTML += ("Child div id: " + event.target.id + "</br>");
        pid.innerHTML += ("Parent div id: " + this.id + "</br>");
    });
   
}