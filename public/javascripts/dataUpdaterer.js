function updateData() {
    $.getJSON("/" + window.user + "/all", function(data) {
        var html = "";
        var unread = 0;
        for(var i in data) {
            var rowStyle = "";
            if (data[i].acknowledged === "false") {
                var rowStyle = "font-weight: bold;";
                unread += 1;
            }
            html += '<tr style="' + rowStyle + '"><td>' + data[i].creation + '</td>';
            html += "<td>" + data[i].message + "</td>";
            html += '<td><a data-id="' + data[i].id + '" href="' + data[i].url + '" target="_blank">View</a></td>';
            html += "</tr>";
        }
        $('tbody').html(html);

        $('title').html("(" + unread + ") Notifications for " + window.user);

        if(window.previousData && data.length > window.previousData.length) {
            sendNotification("You have new messages from realestate.com.au");
        }

        $('a').click(function(event){
            $.ajax({url: "/notifications/" + $(this).data().id + "/acknowledge", type: "POST"});
        });
        window.previousData = data;
    });
}

window.setInterval(updateData,1000);

function sendNotification(message) {
    console.log("sending notification");
    if (window.webkitNotifications.checkPermission() == 0) { // 0 is PERMISSION_ALLOWED
        console.log('permission granted');
        // function defined in step 2
        window.webkitNotifications.createNotification(
            'http://s2.rea.reastatic.net/rs/img/favicon.ico$$164.5489-12', message, "A property has changed").show();
    };
};

function requestPermission() {
    window.webkitNotifications.requestPermission();
};
