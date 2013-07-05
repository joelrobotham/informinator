function updateData() {
    $.getJSON("/" + window.user + "/recent", function(data) {
        var html = "";
        for(var i in data) {
            html += "<tr><td>A Date</td>";
            html += "<td>" + data[i].message + "</td>";
            html += '<td><a href="' + data[i].url + '" target="_blank">View</a></td>';
            html += "</tr>";
        }
        $('tbody').html(html);

        $('title').html("(" + data.length + ") Notifications for " + window.user);
    });
}

window.setInterval(updateData,1000);