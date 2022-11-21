(function() {
    $("#tabfuncionarios").on("click", ".js-delete", function() {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalfuncionario").modal("show");
    });

    $("#btnsim").on("click", function() {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        console.log(id)
        $.ajax({
            url: "/funcionarios/deletar/" + id,
            method: "GET",
            success: function() {
                window.location.href="/funcionarios";
            }
        });
    });
})();