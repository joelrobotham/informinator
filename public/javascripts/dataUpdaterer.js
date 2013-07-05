function updateData() {
    $.getJSON("/" + window.user + "/all", function(data) {
        var html = "";
        for(var i in data) {
            var rowStyle  = data[i].acknowledged === "false" ? "font-weight: bold;" : "";
            html += '<tr style="' + rowStyle + '"><td>' + data[i].creation + '</td>';
            html += "<td>" + data[i].message + "</td>";
            html += '<td><a data-id="' + data[i].id + '" href="' + data[i].url + '" target="_blank">View</a></td>';
            html += "</tr>";
        }
        $('tbody').html(html);

        $('title').html("(" + data.length + ") Notifications for " + window.user);

        if(window.previousData && data.length > window.previousData.length) {
            alert("You have new notifications");
        }

        $('a').click(function(event){
            $.ajax({url: "/notifications/" + $(this).data().id + "/acknowledge", type: "POST"});
        });
        window.previousData = data;
    });
}

window.setInterval(updateData,1000);
