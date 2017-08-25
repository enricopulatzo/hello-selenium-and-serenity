var appNs = appNs || {};

(function ($, app) {
  app.homepage = app.homepage || {};
  app.homepage.init = function () {
    $('#clickMe').on('click', function (evt) {
      app.homepage.fetch()
        .done(function (result) {
          console.info('done', arguments);
          $('#results').html([
            '<div class="panel panel-info"><div class="panel-heading">Result</div>',
            '<div class="panel-body">' + result + '</div>',
            '</div>'
          ].join(''));
        })
        .fail(function (result) {
          console.error('fail', arguments);
          $('#results').html([
            '<div class="panel panel-danger"><div class="panel-heading">An Error Occurred</div>',
            '<div class="panel-body">' + result.responseJSON.detail + '</div>',
            '</div>'
          ].join(''));
        })
        .always(function (xhr, status) {
          console.debug('status', status);
          console.debug('xhr', xhr);
        });
    });
  };
})(jQuery, appNs);
