/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$("#formValidate").validate({
    rules: {
        funcional: {
            required: true,
            minlength: 5
        },
        password: {
            required: true,
            minlength: 6
        },
        //For custom messages
        messages: {
            funcional: {
                required: "Entre com sua funcional",
                minlength: "No mínimo 5 caracteres"
            },
        },
        errorElement: 'div',
        errorPlacement: function (error, element) {
            var placement = $(element).data('error');
            if (placement) {
                $(placement).append(error)
            } else {
                error.insertAfter(element);
            }
        }
    }
});