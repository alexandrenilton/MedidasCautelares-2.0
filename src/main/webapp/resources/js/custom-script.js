/*================================================================================
 Item Name: Materialize - Material Design Admin Template
 Version: 3.1
 Author: GeeksLabs
 Author URL: http://www.themeforest.net/user/geekslabs
 ================================================================================

 NOTE:
 ------
 PLACE HERE YOUR OWN JS CODES AND IF NEEDED.
 WE WILL RELEASE FUTURE UPDATES SO IN ORDER TO NOT OVERWRITE YOUR CUSTOM SCRIPT IT'S BETTER LIKE THIS. */

$(document).ready(function () {
    $('#data-table-simple').dataTable({
        "language": {
            "paginate": {
                "previous": "Anterior",
                "next": "Próximo",
                "first": "Primeiro",
                "last": "Último"
            },
            "empty-table": "Nenhum registro encontrado",
            "info": "Exibindo _START_ até _END_ de _TOTAL_ registros",
            "lengthMenu": "",
            "search": "Pesquisar",
            "zeroRecords": "Nada encontrado",
            "infoEmpty": "Nada para exibir",
            "infoFiltered": " - Filtrado de  _MAX_ registros"
        }
    })
    ;
});
