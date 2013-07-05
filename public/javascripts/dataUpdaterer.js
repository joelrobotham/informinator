function updateData() {
    $.getJSON("/" + window.user + "/recent", function(data) {
        var html = "";
        for(var i in data) {
            html += "<tr><td>A Date</td>";
            html += "<td>" + data[i].message + "</td>";
            html += "</tr>";
        }
        $('tbody').html(html);
    });
}

window.setInterval(updateData,1000);