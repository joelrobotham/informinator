window.sampleproperties = [{id: "Price updated for 1 Smith Street, Richmond", url:"http://www.realestate.com.au/property-apartment-vic-richmond-113998259"},
    {id: "Auction today for 2 Victoria Street, Richmond", url:"http://www.realestate.com.au/property-house-vic-richmond-114122019"},
    {id: "Inspection time changed for 34 River Street, Richmond", url:"http://www.realestate.com.au/property-townhouse-vic-richmond-114109519"},
    {id: "Vendor in distress at 35 Bridge Road, Richmond", url:"http://www.realestate.com.au/property-townhouse-vic-richmond-114237143"},
    {id: "House party tonight!!! at 87 Beach Street, Mornington", url:"http://www.realestate.com.au/project-morven+manor-vic-mornington-600002163"},
    {id: "Updated photos for Bob Street, Richmond", url:"http://www.realestate.com.au/property-house-vic-richmond-114228491"}];

window.emails = ["joel@blah.com","foo@bar.com"];

$('#form').submit(function(event) {
    event.preventDefault();
    var form = this,
        formSubmitData = {},
        formData = $(form).serializeArray();
    for(var i in formData) {
        formSubmitData[formData[i].name] = formData[i].value;
    }

    $.ajax({url: '/notifications/testAlert',
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(formSubmitData)})
        .done(function() {
            $("h2").html("Notification Send")
            var randomPropNo = Math.floor((Math.random()*5));
            var randomEmailNo = Math.floor((Math.random()*2));
            var prop = window.sampleproperties[randomPropNo];
            $("input[name='message']").val(prop.id);
            $("input[name='url']").val(prop.url);
            $("input[name='email']").val(emails[randomEmailNo]);
        });
});

$('#topicForm').submit(function(event) {
    event.preventDefault();
    var form = this,
        formSubmitData = {},
        formData = $(form).serializeArray();
    for(var i in formData) {
        formSubmitData[formData[i].name] = formData[i].value;
    }

    $.ajax({url: '/notifications/topic/' + formSubmitData.messageType,
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(formSubmitData)})
        .done(function() {
            $("h2").html("Notification Send")
            var randomPropNo = Math.floor((Math.random()*6));
            var prop = window.sampleproperties[randomPropNo];
            $("input[name='message']").val("New property " + prop.id);
            $("input[name='url']").val(prop.url);
        });
});

