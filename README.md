What You Need
========

To Run:

1. Git client

2. Gradle

To Edit in Eclipse:

1. Eclipse

2. Git client

3. Gradle

Setup in Eclipse
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

3. Open site at http://localhost:8080/index.htm
