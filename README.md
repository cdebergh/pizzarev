Setup
========

1. Checkout to workspace.

cd _eclipse workspace_
git clone _this url_

2. In project, run:

gradle eclipse

3. In eclipse, File > Import > Existing Project into Workspace.
   Choose project and DO NOT check off to copy since it's in
   your workspace already as part of step 1.

Run
========

1. In project, run:

gradle build

2. Execute war

java -jar build/libs/pizzarev.war
