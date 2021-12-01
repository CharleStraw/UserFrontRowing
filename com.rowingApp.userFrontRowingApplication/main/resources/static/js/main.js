/**
 * Created by z00382545 on 10/20/16.
 */

(function ($) {
    $.toggleShowPassword = function (options) {
        var settings = $.extend({
            field: "#password",
            control: "#toggle_show_password",
        }, options);

        var control = $(settings.control);
        var field = $(settings.field)

        control.bind('click', function () {
            if (control.is(':checked')) {
                field.attr('type', 'text');
            } else {
                field.attr('type', 'password');
            }
        })
    };

    $.transferDisplay = function () {
        $("#transferFrom").change(function() {
            if ($("#transferFrom").val() == 'Primary') {
                $('#transferTo').val('Savings');
            } else if ($("#transferFrom").val() == 'Savings') {
                $('#transferTo').val('Primary');
            }
        });

        $("#transferTo").change(function() {
            if ($("#transferTo").val() == 'Primary') {
                $('#transferFrom').val('Savings');
            } else if ($("#transferTo").val() == 'Savings') {
                $('#transferFrom').val('Primary');
            }
        });
    };



}(jQuery));


$(document).ready(function($){
  $('.date').mask('00/00/0000');
  $('.time').mask('00:00:00');
  $('#wats').mask('0000');
  $('.date_time').mask('00/00/0000 00:00:00');
  $('.cep').mask('00000-000');
  $('.phone').mask('0000-0000');
  $('.phone_with_ddd').mask('(00) 0000-0000');
  $('.phone_us').mask('(000) 000-0000');
  $('.mixed').mask('AAA 000-S0S');
  $('.cpf').mask('000.000.000-00', {reverse: true});
  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
  $('.money').mask('000.000.000.000.000,00', {reverse: true});
  $('.money2').mask("#.##0,00", {reverse: true});
  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {
    translation: {
      'Z': {
        pattern: /[0-9]/, optional: true
      }
    }
  });
  $('.ip_address').mask('099.099.099.099');
  $('.percent').mask('##0,00%', {reverse: true});
  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
  $('.fallback').mask("00r00r0000", {
      translation: {
        'r': {
          pattern: /[\/]/,
          fallback: '/'
        },
        placeholder: "__/__/____"
      }
    });
  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});
});



function getPicture(){

var x =document.getElementById("idPic").value;
alert(x);
  window.open("http://localhost:8000/test/"+document.getElementById("idPic") , "My Window", "height=700,width=1400");


}
//$(document).ready(function() {
//
//    var confirm = function() {
//        bootbox.confirm({
//            title: "Appointment Confirmation",
//            message: "Do you really want to schedule this appointment?",
//            buttons: {
//                cancel: {
//                    label: '<i class="fa fa-times"></i> Cancel'
//                },
//                confirm: {
//                    label: '<i class="fa fa-check"></i> Confirm'
//                }
//            },
//            callback: function (result) {
//                if (result == true) {
//                    $('#appointmentForm').submit();
//                } else {
//                    console.log("Scheduling cancelled.");
//                }
//            }
//        });
//    };
//
//    $.toggleShowPassword({
//        field: '#password',
//        control: "#showPassword"
//    });
//
//    $.transferDisplay();
//
//    $(".form_datetime").datetimepicker({
//        format: "yyyy-mm-dd hh:mm",
//        autoclose: true,
//        todayBtn: true,
//        startDate: "2013-02-14 10:00",
//        minuteStep: 10
//    });
//
//    $('#submitAppointment').click(function () {
//        confirm();
//    });
//
//});




