function login() {
	var server = $('#server').val();
    var port  = $('#port').val();
	var usr = $('#username').val();
	var pwd = $('#password').val();

    $('#serverUrl').html(server + ':' + port);

	if(server.length > 0 && usr.length > 0 && port.length > 0 && pwd.length > 0) {
        // Send data to server through the ajax call
        // action is functionality we want to call and outputJSON is our data
            $.ajax({
            	url:  'http://' + server + ':' + port + '/api/user/login',
                data: { email : usr, password: pwd },
                type: 'post',                   
                dataType: 'json',
                
                beforeSend: function() {
                    // This callback function will trigger before data is sent
                    $.mobile.loading( 'show');
                },
                complete: function() {
                    // This callback function will trigger on data sent/received complete
                    $.mobile.loading( 'hide');
                },
                success: function (result) {
                    if(result.token) {
                        $('#userEmail').val(usr);
                        window.location.href = '#alerts';
                        init();
                    } else {
                        alert('Login unsuccessful!'); 
                    }
                },
                error: function (request, error) {
                    // This callback function will trigger on unsuccessful action
                    alert('Network error has occurred please try again!');
                }
            });                   
    } else {
        alert('Please verify if all fields are fill');
    }
}

function fillSensors() {    
    var url = 'http://' + $('#serverUrl').text() + '/api/sensor';

    $.getJSON(url, function(data) {

      var listSensors = $('#list-sensors');
      $.each(data, function(key, value) {
        listSensors.append('<li>' + 
            '<label><input name="servers[]" type="checkbox" /> ' + 
            value.name + ' - ' + value.planet +
            ' </label>' +
            '</li>');
      });
    });
}

function saveSettings() {

    var usr = $('#userEmail').val();
    var maxTemp = $('#max').val();
    var minTemp = $('#min').val();
    var skyColor = $('#skyColor').val();
    var alertSwitch = $('#alertSwitch').val();
    var serverUrl = 'http://' + $('#serverUrl').text() + '/api/user/settings'

    $.ajax({
        url: serverUrl ,
        data: { 
                email : usr, 
                max: maxTemp,
                min: minTemp,
                sky: skyColor,
                alert: alertSwitch },
        type: 'post',                   
        dataType: 'json',
        
        beforeSend: function() {
            // This callback function will trigger before data is sent
            $.mobile.loading( 'show');
        },
        complete: function() {
            // This callback function will trigger on data sent/received complete
            $.mobile.loading( 'hide');
        },
        success: function (result) {
            if(result.token) {
                
                alert('Settings changed successfully');
            } else {
                alert('Settings changed unsuccessful!'); 
            }
        },
        error: function (request, error) {
            // This callback function will trigger on unsuccessful action
            alert('Network error has occurred please try again!');
        }
    });
}

function logout() {
    window.location.href = '#page-login';
    $('userEmail').val('');
}

