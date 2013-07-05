window.sampleproperties = [{id: "113998259", url:"http://www.realestate.com.au/property-apartment-vic-richmond-113998259"},
    {id: "114122019", url:"http://www.realestate.com.au/property-house-vic-richmond-114122019"},
    {id: "114109519", url:"http://www.realestate.com.au/property-townhouse-vic-richmond-114109519"},
    {id: "114237143", url:"http://www.realestate.com.au/property-townhouse-vic-richmond-114237143"},
    {id: "114228491", url:"http://www.realestate.com.au/property-house-vic-richmond-114228491"}];

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
            $("input[name='message']").val("New property " + prop.id);
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

