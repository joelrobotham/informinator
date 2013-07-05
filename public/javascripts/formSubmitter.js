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
            form.reset();
            alert("Notification submitted");
        })
        .fail(function() {
            form.reset();
        });
});
