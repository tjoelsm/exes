import { WebExesPage } from './app.po';

describe('web-exes App', function() {
  let page: WebExesPage;

  beforeEach(() => {
    page = new WebExesPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
