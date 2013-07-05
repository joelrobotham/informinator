function updateData() {
    $.getJSON("/" + window.user + "/recent", function(data) {
        var html = "";
        for(var i in data) {
            html += "<tr><td>" + data[i].creation + "</td>";
            html += "<td>" + data[i].message + "</td>";
            html += '<td><a href="' + data[i].url + '" target="_blank">View</a></td>';
            html += "</tr>";
        }
        $('tbody').html(html);

        $('title').html("(" + data.length + ") Notifications for " + window.user);

        if(window.previousData && data.length > window.previousData.length) {
            alert("You have new notifications");
        }
        window.previousData = data;
    });
}

window.setInterval(updateData,1000);
