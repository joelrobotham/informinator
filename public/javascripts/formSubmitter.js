$('#form').submit(function(event) {
    event.preventDefault();
    var formSubmitData = {},
        formData = $(this).serializeArray();
    for(var i in formData) {
        formSubmitData[formData[i].name] = formData[i].value;
    }

    $.ajax({url: '/notifications/testAlert',
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(formSubmitData)});
});