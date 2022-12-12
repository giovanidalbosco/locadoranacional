(function() {
    $("#tabclientes").on("click", ".js-delete", function() {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");
    });

    $("#btnsim").on("click", function() {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        console.log(id)
        $.ajax({
            url: "/clientes/deletar/" + id,
            method: "GET",
            success: function() {
                window.location.href="/clientes";
            }
        });
    });
})();