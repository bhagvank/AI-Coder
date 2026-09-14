# AI Coder

**Neural Sketch Based Framework**

Repository: [bhagvank/AI-Coder](https://github.com/bhagvank/AI-Coder) · Branch: `Chartreuse`

Author: Bhagvan Kommadi, Quantica Computacao (bhagvank@quanticacomputacao.com)

## Overview

AI Coder is an AI bot that generates code in PHP, Ruby on Rails, Django, Java, and Python — including Python/Django and other frameworks. Rather than requiring developers to write code by hand, AI Coder is given basic information about the entities involved in the application, and it produces the corresponding code.

AI Coder is built on **neural sketch learning**: an artificial neural network trained to recognize code-level patterns across different software by "reading" large volumes of human-written code and repository content. From this training it learns to generate code based on an application's components.

Key capabilities include:

- Generating application code from entity, rule, tool, and protocol definitions
- Reading from a code repository and generating code based on existing components
- Creating sample code and unit tests for software frameworks
- Generating test data
- Extensibility to support additional software APIs for code generation

## Chartreuse — Reference Application

The [`Chartreuse/`](Chartreuse/) folder contains the **runtime reference application** for the AI-Coder framework. Chartreuse (branded **Architect Corner**) is a metadata-driven Java EE web app that demonstrates:

- **Metadata-driven CRUD** — XML-configured forms, lists, and entity operations via Java reflection
- **Multi-tier persistence** — JDBC DAOs against MySQL, MongoDB for big-data staging
- **Analytics** — CSV ingestion, Java2D chart generation with linear regression
- **AI / sentiment** — RSS feed analysis and keyword-based sentiment detection

```
Chartreuse/
├── src/org/archcorner/chartreuse/    # Core: metadata, delegates, DAOs, POJOs, bigdata, charting
├── src/org/architectcorner/ai/       # AI: sentiment analysis, media response
├── WebContent/                       # 35 JSP pages (CRUD, analytics, sentiment)
├── belfortappconfig.xml              # Entity/view/form metadata (8 entities)
└── architecture.md                   # Detailed architecture documentation
```

See [Chartreuse/architecture.md](Chartreuse/architecture.md) for system diagrams, layer design, entity model, and request flows.

### Quick Start (Chartreuse)

**Prerequisites:** Java 9, Eclipse WTP, Apache Tomcat 9, MySQL (`belfort` database), MongoDB

1. Import the Chartreuse project into Eclipse
2. Update the XML config path in `AppConfigManager.java` to point to your local `belfortappconfig.xml`
3. Configure MySQL/MongoDB credentials in `JDBCManager.java`
4. Deploy to Tomcat — welcome page is `Login.jsp`

### Configured Entities

| # | Entity | Layers |
|---|--------|--------|
| 1 | User | POJO, DAO, BusinessDelegate |
| 2 | Disaster | POJO, DAO, BusinessDelegate, Service |
| 3 | Customer | POJO, DAO, BusinessDelegate, Service |
| 4 | Order | POJO, DAO, BusinessDelegate, Service |
| 5 | Product | POJO, DAO, BusinessDelegate, Service |
| 6 | Resource | POJO, DAO, BusinessDelegate, Service |
| 7 | Vendor | POJO, DAO, BusinessDelegate |
| 8 | Partner | POJO, DAO, BusinessDelegate |

## How It Works

### Neural Sketch Learning

Code generation is driven by a syntax and semantics specification supplied as input. The framework is trained by being shown applications that are already configured within it (a **supervised learning** approach). Training input consists of a set of applications configured in terms of their views, entities, and actions; metadata from these configurations teaches the framework the application's semantics — its data types, methods, control flow, exceptions, and entity types.

The neural sketch framework combines **neural learning and combinatorial search** to identify patterns and render applications, while enforcing the constraints defined in the configuration file. Internally, the source code can build tree-based syntactic models ("sketches") of a program.

A **sketch** corresponds to a class, entity, or method — including its arguments, return values, and control flow.

### Application Framework

The framework follows a **metadata-driven architecture**, with metadata stored and modeled using the object repository pattern. Metadata is read to render applications assuming a microservices-based architecture with the following layers:

- **Service layer**
- **Services client (mobile)**
- **Persistence layer**
- **Data access layer**
- **Database layer**

Each layer is implemented using language SDK– and platform-specific patterns and practices, with metadata attributes configured per layer. Applications built with the framework are configurable and extensible through events, delegates, templates, services, and classes, and support customization without code changes (with custom modules loadable when code changes are needed).

This approach targets **native, hybrid, and web-based mobile applications**, and can be used across iOS, Android, and Windows, along with their respective programming language SDKs. Because the approach is not tied to a specific technology stack, it can be upgraded by changing the framework's implementation in the relevant layer.

## Application Architecture

The application architecture is designed to be extended with commercial packages and software, using only the functionality required, and includes:

- **Security & licensing** enforcement
- **Auditing** of inserts, edits, and deletions
- **Multi-tiered, entity-context sensitive security** for data and actions across user roles and groups
- **Admin-level metadata management** through screens, plus developer-level configuration of metadata and programmatic updates

### Platform Features

| Feature | Description |
|---|---|
| Search | Google-like full search across platform data |
| Document Management | Core document management with third-party integration support |
| Business Rules | Rules linked to events or time |
| Workflow | Base workflow functionality, extensible per product |
| Scheduler | Admin-configurable periodic actions |
| Calendar | Scheduling of calendar events |
| Notifications | Rule-based notifications via email and other formats |
| Reporting | Scheduled and ad-hoc reporting across all data |
| Internationalization | Multiple languages, currencies, and locales |
| Integrations | Event- or batch-driven synchronization with external systems via configurable protocols |
| User Interface | Web-based UI, customizable by administrators |
| Domain Objects | Creation/modification of domain objects, attributes, and relationships to other objects and reference data |

## Sample Configuration

The framework is driven by XML configuration that defines an application's views, forms, and data operations. Chartreuse uses `belfortappconfig.xml` with this structure. A sample `User` entity configuration includes:

- **View** — defines the fields shown for an entity (e.g. `UserId`, `UserName`, `Password`)
- **Form** — defines the fields collected on create (e.g. `UserName`, `Password`)
- **Update** — defines the form, ID field, search field, and editable fields for updates
- **Delete** — defines the form, ID field, search field, and fields used for deletion

Example (`User` view):

```xml
<app>
  <view>
    <name>User</name>
    <viewno>1</viewno>
    <viewFields>
      <viewField>UserId</viewField>
      <viewField>UserName</viewField>
      <viewField>Password</viewField>
    </viewFields>
  </view>
  ...
</app>
```

At runtime, `AppConfigManager` reads this XML to drive JSP form generation, and `MetadataManager` uses Java reflection to invoke the matching `{Entity}BusinessDelegate` methods — no per-entity JSP code is required.

## Web Service Layer

AI Coder also generates the corresponding SOAP/WSDL web service layer for an entity. For the `User` entity, the generated `UserService` exposes:

- `getAll` — retrieve all users
- `getUser` — retrieve a user by username
- `getUserById` — retrieve a user by ID
- `insertUser` — create a user
- `updateUser` — update a user
- `deleteUser` — delete a user

Each operation's request/response schema (types, elements, and messages) is generated from the `User` complex type, which includes `userId`, `userName`, and `password`.

## Repository Branches

| Branch | Contents |
|--------|----------|
| `Chartreuse` | Runtime reference application (Java EE, JSP, MySQL, MongoDB) |
| `goldenrod` | Code generation engine (multi-target: Java, PHP, AngularJS, Django) |
| `leather` | Additional framework modules |
| `main` | Project root documentation and papers |

## Conclusion

The application configuration can be extended across additional layers such as services, entities, persistence, and data access. This neural sketch–based mobile application framework can be applied to a wide range of software applications beyond the sample shown here. Chartreuse provides the working runtime that consumes generated code and renders metadata-driven applications end to end.

## References

1. V. Murali, L. Qi, S. Chaudhuri, C. Jermaine, *Neural Sketch Learning for Conditional Program Generation*
2. M. Amodio, S. Chaudhuri, T. Reps, *Neural Attribute Machines for Program Generation*
3. M. Balog, A. L. Gaunt, M. Brockschmidt, S. Nowozin, *DeepCoder: Learning to Write Programs*
