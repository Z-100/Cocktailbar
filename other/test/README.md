# React Test cases

| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| The components name and the activity done | What should happen after doing something | What actually happened after doing so | :heavy_check_mark: or :x:|

## Static pages
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Home: Viewing page | Text dispalyed correctly | Text dispalyed correctly | :heavy_check_mark: |
| Impressum: Viewing page | Text dispalyed correctly | Text dispalyed correctly | :heavy_check_mark: |
| Help: Viewing page | Error 404 page, as help page not present | Error 404 page, as help page not present | :heavy_check_mark: |
| Error: Viewing page | Text displayed correctly, with link to navigate back to home | Text displayed correctly, with link to navigate back to home | :heavy_check_mark: |
| About: Viewing page | Text displayed correctly | Text displayed correctly | :heavy_check_mark: |

## Login page
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Login: Viewing page | Information displayed correctly | Information displayed correctly | :heavy_check_mark: |
| Login: Correct info entered | Logged into account<br/>Token & E-Mail saved to state & cookie, which can be retrieved again | Logged into account<br/>Token & E-Mail saved to state & cookie, which can be retrieved again | :heavy_check_mark: |
| Login: Incorrect info entered - B-Layer | Error displaying with reasoning | Error displaying with reasoning | :heavy_check_mark: |
| Login: Incorrect info entered - P-Layer | E-Mail without "@": Error<br/>Field empty: Error | E-Mail without "@": Error<br/>Field empty: Error | :heavy_check_mark: |

## Register page
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Register: Viewing page | Information displayed correctly | Information displayed correctly | :heavy_check_mark: |
| Register: Correct info entered | Account saved to database via API<br/>Logged into account<br/>Token & E-Mail saved to state & cookie | Account saved to database via API<br/>Logged into account<br/>Token & E-Mail saved to state & cookie | :heavy_check_mark: |
| Register: Incorrect info entered - B-Layer | Error displaying with reasoning e.g. E-Mail / Username already taken | Error displaying with reasoning e.g. E-Mail / Username already taken | :heavy_check_mark: |
| Register: Incorrect info entered - P-Layer | E-Mail without "@": Error<br/>Field empty: Error | E-Mail without "@": Error<br/>Field empty: Error | :heavy_check_mark: |

## Search page
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Search: Viewing page | Information displayed correctly | Information displayed correctly | :heavy_check_mark: |
| Search: Correct info entered | Recipes of user shown correclty | Recipes of user shown correclty | :heavy_check_mark: |
| Search: Incorrect info entered - B-Layer | Error displaying with reasoning e.g. No recipes found | Error displaying with reasoning e.g. No recipes found | :heavy_check_mark: |
| Search: Incorrect info entered - P-Layer | Field empty: Error | Field empty: Error | :heavy_check_mark: |

## Recommended page
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Recommended: Viewing page | Information displayed correctly | Information displayed correctly | :heavy_check_mark: |
| Recommended: Any Error | Error displayed with reasoning e.g. No recipes found | Error displayed with reasoning e.g. No recipes found | :heavy_check_mark: |

## Create page
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Create: Viewing page | Information displayed correctly | Information displayed correctly | :heavy_check_mark: |
| Create: Correct info entered | Recipe saved in database via API + Success info text shown | Recipe saved in database via API + Success info text shown | :heavy_check_mark: |
| Create: Incorrect info entered - P-Layer | Field empty: Error | Field empty: Error | :heavy_check_mark: |

## Log off "page"
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Log off: Button pressed | cookie & state destroyed, logging the user off. Can still navigate viewer pages, but can not access member pages | cookie & state destroyed, logging the user off.  Can still navigate viewer pages, but can not access member pages | :heavy_check_mark: |

## Profile page
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Create: Viewing page | Information displayed correctly. Only E-Mail Address and Usenrame shown | Information displayed correctly. Only E-Mail Address and Usenrame shown | :heavy_check_mark: |

## Navbar component
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| Navbar: Viewing as viewer | Home & Search & Recommended & About & Login & Register Button showing | Home & Search & Recommended & About & Login & Register Button showing | :heavy_check_mark: |
| Navbar: Viewing as member | Home & Search & Recommended & About & Create & Log off & Profile Button showing | Home & Search & Recommended & About & Create & Log off & Profile Button showing | :heavy_check_mark: |
| Navbar: Logged in | The user can not access the login or register pages | The user can not access the login or register pages | :heavy_check_mark: |
| Navbar: Logged off | The user can not access the Create, Log off or Profile pages | The user can not access the Create, Log off or Profile pages | :heavy_check_mark: |

## API-Requests
| Tested component | Expected result | Actual result | Passed |
|:--|:--|:--|:--|
| API-Request: Login | If information entered correctly: Token of user sent back as THE sucess, elsewise error warning | If information entered correctly: Token of user sent back as THE sucess, elsewise error warning | :heavy_check_mark: |
| API-Request: Register | If information entered correctly: Token of user sent back as THE sucess, elsewise error warning| If information entered correctly: Token of user sent back as THE sucess, elsewise error warning | :heavy_check_mark: |
| API-Request: Get drink / recipe | If information entered correctly: All drinks beloning to user / All recommended drinks retrieved as THE success info, elsewise error warning | If information entered correctly: All drinks beloning to user / All recommended drinks retrieved as THE success info, elsewise error warning | :heavy_check_mark: |
| API-Request: Insert drink / recipe | If information entered correctly: Drink inserted into database with success info, elsewise error warning | If information entered correctly: Drink inserted into database with success info, elsewise error warning | :heavy_check_mark: |

