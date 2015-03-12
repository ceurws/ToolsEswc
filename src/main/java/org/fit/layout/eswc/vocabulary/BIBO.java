package org.fit.layout.eswc.vocabulary;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * The Bibliographic Ontology.
 * <p>
 * The Bibliographic Ontology describes bibliographic things on the
 * semantic Web in RDF. This ontology can be used as a citation ontology,
 * as a document classification ontology, or simply as a way to describe
 * any kind of document in RDF. It has been inspired by many existing
 * document description metadata formats, and can be used as a common
 * ground for converting other bibliographic data sources..
 * <p>
 * Namespace BIBO.
 * Prefix: {@code <http://purl.org/ontology/bibo/>}
 */
public class BIBO {

	/** {@code http://purl.org/ontology/bibo/} **/
	public static final String NAMESPACE = "http://purl.org/ontology/bibo/";

	/** {@code bibo} **/
	public static final String PREFIX = "bibo";

	/**
	 * abstract
	 * <p>
	 * {@code http://purl.org/ontology/bibo/abstract}.
	 * <p>
	 * A summary of the resource.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/abstract">abstract</a>
	 */
	public static final URI _abstract;

	/**
	 * Academic Article
	 * <p>
	 * {@code http://purl.org/ontology/bibo/AcademicArticle}.
	 * <p>
	 * A scholarly academic article, typically published in a journal.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/AcademicArticle">AcademicArticle</a>
	 */
	public static final URI AcademicArticle;

	/**
	 * {@code http://purl.org/ontology/bibo/affirmedBy}.
	 * <p>
	 * A legal decision that affirms a ruling.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/affirmedBy">affirmedBy</a>
	 */
	public static final URI affirmedBy;

	/**
	 * annotates
	 * <p>
	 * {@code http://purl.org/ontology/bibo/annotates}.
	 * <p>
	 * Critical or explanatory note for a Document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/annotates">annotates</a>
	 */
	public static final URI annotates;

	/**
	 * date argued
	 * <p>
	 * {@code http://purl.org/ontology/bibo/argued}.
	 * <p>
	 * The date on which a legal case is argued before a court. Date is of
	 * format xsd:date
	 *
	 * @see <a href="http://purl.org/ontology/bibo/argued">argued</a>
	 */
	public static final URI argued;

	/**
	 * Article
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Article}.
	 * <p>
	 * A written composition in prose, usually nonfiction, on a specific
	 * topic, forming an independent part of a book or other publication, as
	 * a newspaper or magazine.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Article">Article</a>
	 */
	public static final URI Article;

	/**
	 * {@code http://purl.org/ontology/bibo/asin}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/asin">asin</a>
	 */
	public static final URI asin;

	/**
	 * audio document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/AudioDocument}.
	 * <p>
	 * An audio document; aka record.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/AudioDocument">AudioDocument</a>
	 */
	public static final URI AudioDocument;

	/**
	 * audio-visual document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/AudioVisualDocument}.
	 * <p>
	 * An audio-visual document; film, video, and so forth.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/AudioVisualDocument">AudioVisualDocument</a>
	 */
	public static final URI AudioVisualDocument;

	/**
	 * list of authors
	 * <p>
	 * {@code http://purl.org/ontology/bibo/authorList}.
	 * <p>
	 * An ordered list of authors. Normally, this list is seen as a priority
	 * list that order authors by importance.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/authorList">authorList</a>
	 */
	public static final URI authorList;

	/**
	 * {@code http://purl.org/ontology/bibo/bdarcus}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/bdarcus">bdarcus</a>
	 */
	public static final URI bdarcus;

	/**
	 * Bill
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Bill}.
	 * <p>
	 * Draft legislation presented for discussion to a legal body.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Bill">Bill</a>
	 */
	public static final URI Bill;

	/**
	 * Book
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Book}.
	 * <p>
	 * A written or printed work of fiction or nonfiction, usually on sheets
	 * of paper fastened or bound together within covers.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Book">Book</a>
	 */
	public static final URI Book;

	/**
	 * Book Section
	 * <p>
	 * {@code http://purl.org/ontology/bibo/BookSection}.
	 * <p>
	 * A section of a book.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/BookSection">BookSection</a>
	 */
	public static final URI BookSection;

	/**
	 * Brief
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Brief}.
	 * <p>
	 * A written argument submitted to a court.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Brief">Brief</a>
	 */
	public static final URI Brief;

	/**
	 * chapter
	 * <p>
	 * {@code http://purl.org/ontology/bibo/chapter}.
	 * <p>
	 * An chapter number
	 *
	 * @see <a href="http://purl.org/ontology/bibo/chapter">chapter</a>
	 */
	public static final URI chapter;

	/**
	 * Chapter
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Chapter}.
	 * <p>
	 * A chapter of a book.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Chapter">Chapter</a>
	 */
	public static final URI Chapter;

	/**
	 * cited by
	 * <p>
	 * {@code http://purl.org/ontology/bibo/citedBy}.
	 * <p>
	 * Relates a document to another document that cites the first document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/citedBy">citedBy</a>
	 */
	public static final URI citedBy;

	/**
	 * cites
	 * <p>
	 * {@code http://purl.org/ontology/bibo/cites}.
	 * <p>
	 * Relates a document to another document that is cited by the first
	 * document as reference, comment, review, quotation or for another
	 * purpose.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/cites">cites</a>
	 */
	public static final URI cites;

	/**
	 * Code
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Code}.
	 * <p>
	 * A collection of statutes.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Code">Code</a>
	 */
	public static final URI Code;

	/**
	 * {@code http://purl.org/ontology/bibo/coden}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/coden">coden</a>
	 */
	public static final URI coden;

	/**
	 * Collected Document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/CollectedDocument}.
	 * <p>
	 * A document that simultaneously contains other documents.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/CollectedDocument">CollectedDocument</a>
	 */
	public static final URI CollectedDocument;

	/**
	 * Collection
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Collection}.
	 * <p>
	 * A collection of Documents or Collections
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Collection">Collection</a>
	 */
	public static final URI Collection;

	/**
	 * Conference
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Conference}.
	 * <p>
	 * A meeting for consultation or discussion.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Conference">Conference</a>
	 */
	public static final URI Conference;

	/**
	 * content
	 * <p>
	 * {@code http://purl.org/ontology/bibo/content}.
	 * <p>
	 * This property is for a plain-text rendering of the content of a
	 * Document. While the plain-text content of an entire document could be
	 * described by this property.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/content">content</a>
	 */
	public static final URI content;

	/**
	 * list of contributors
	 * <p>
	 * {@code http://purl.org/ontology/bibo/contributorList}.
	 * <p>
	 * An ordered list of contributors. Normally, this list is seen as a
	 * priority list that order contributors by importance.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/contributorList">contributorList</a>
	 */
	public static final URI contributorList;

	/**
	 * court
	 * <p>
	 * {@code http://purl.org/ontology/bibo/court}.
	 * <p>
	 * A court associated with a legal document; for example, that which
	 * issues a decision.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/court">court</a>
	 */
	public static final URI court;

	/**
	 * Court Reporter
	 * <p>
	 * {@code http://purl.org/ontology/bibo/CourtReporter}.
	 * <p>
	 * A collection of legal cases.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/CourtReporter">CourtReporter</a>
	 */
	public static final URI CourtReporter;

	/**
	 * degree
	 * <p>
	 * {@code http://purl.org/ontology/bibo/degree}.
	 * <p>
	 * The thesis degree.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/degree">degree</a>
	 */
	public static final URI degree;

	/**
	 * M.A.
	 * <p>
	 * {@code http://purl.org/ontology/bibo/degrees/ma}.
	 * <p>
	 * masters degree in arts
	 *
	 * @see <a href="http://purl.org/ontology/bibo/degrees/ma">degrees/ma</a>
	 */
	public static final URI degrees_ma;

	/**
	 * M.S.
	 * <p>
	 * {@code http://purl.org/ontology/bibo/degrees/ms}.
	 * <p>
	 * masters degree in science
	 *
	 * @see <a href="http://purl.org/ontology/bibo/degrees/ms">degrees/ms</a>
	 */
	public static final URI degrees_ms;

	/**
	 * PhD degree
	 * <p>
	 * {@code http://purl.org/ontology/bibo/degrees/phd}.
	 * <p>
	 * PhD degree
	 *
	 * @see <a href="http://purl.org/ontology/bibo/degrees/phd">degrees/phd</a>
	 */
	public static final URI degrees_phd;

	/**
	 * director
	 * <p>
	 * {@code http://purl.org/ontology/bibo/director}.
	 * <p>
	 * A Film director.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/director">director</a>
	 */
	public static final URI director;

	/**
	 * distributor
	 * <p>
	 * {@code http://purl.org/ontology/bibo/distributor}.
	 * <p>
	 * Distributor of a document or a collection of documents.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/distributor">distributor</a>
	 */
	public static final URI distributor;

	/**
	 * Document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Document}.
	 * <p>
	 * A document (noun) is a bounded physical representation of body of
	 * information designed with the capacity (and usually intent) to
	 * communicate. A document may manifest symbolic, diagrammatic or
	 * sensory-representational information.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Document">Document</a>
	 */
	public static final URI Document;

	/**
	 * document part
	 * <p>
	 * {@code http://purl.org/ontology/bibo/DocumentPart}.
	 * <p>
	 * a distinct part of a larger document or collected document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/DocumentPart">DocumentPart</a>
	 */
	public static final URI DocumentPart;

	/**
	 * Document Status
	 * <p>
	 * {@code http://purl.org/ontology/bibo/DocumentStatus}.
	 * <p>
	 * The status of the publication of a document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/DocumentStatus">DocumentStatus</a>
	 */
	public static final URI DocumentStatus;

	/**
	 * {@code http://purl.org/ontology/bibo/doi}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/doi">doi</a>
	 */
	public static final URI doi;

	/**
	 * {@code http://purl.org/ontology/bibo/eanucc13}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/eanucc13">eanucc13</a>
	 */
	public static final URI eanucc13;

	/**
	 * Edited Book
	 * <p>
	 * {@code http://purl.org/ontology/bibo/EditedBook}.
	 * <p>
	 * An edited book.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/EditedBook">EditedBook</a>
	 */
	public static final URI EditedBook;

	/**
	 * edition
	 * <p>
	 * {@code http://purl.org/ontology/bibo/edition}.
	 * <p>
	 * The name defining a special edition of a document. Normally its a
	 * literal value composed of a version number and words.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/edition">edition</a>
	 */
	public static final URI edition;

	/**
	 * editor
	 * <p>
	 * {@code http://purl.org/ontology/bibo/editor}.
	 * <p>
	 * A person having managerial and sometimes policy-making responsibility
	 * for the editorial part of a publishing firm or of a newspaper,
	 * magazine, or other publication.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/editor">editor</a>
	 */
	public static final URI editor;

	/**
	 * list of editors
	 * <p>
	 * {@code http://purl.org/ontology/bibo/editorList}.
	 * <p>
	 * An ordered list of editors. Normally, this list is seen as a priority
	 * list that order editors by importance.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/editorList">editorList</a>
	 */
	public static final URI editorList;

	/**
	 * {@code http://purl.org/ontology/bibo/eissn}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/eissn">eissn</a>
	 */
	public static final URI eissn;

	/**
	 * EMail
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Email}.
	 * <p>
	 * A written communication addressed to a person or organization and
	 * transmitted electronically.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Email">Email</a>
	 */
	public static final URI Email;

	/**
	 * {@code http://purl.org/ontology/bibo/Event}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Event">Event</a>
	 */
	public static final URI Event;

	/**
	 * Excerpt
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Excerpt}.
	 * <p>
	 * A passage selected from a larger work.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Excerpt">Excerpt</a>
	 */
	public static final URI Excerpt;

	/**
	 * {@code http://purl.org/ontology/bibo/fgiasson}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/fgiasson">fgiasson</a>
	 */
	public static final URI fgiasson;

	/**
	 * Film
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Film}.
	 * <p>
	 * aka movie.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Film">Film</a>
	 */
	public static final URI Film;

	/**
	 * {@code http://purl.org/ontology/bibo/gtin14}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/gtin14">gtin14</a>
	 */
	public static final URI gtin14;

	/**
	 * {@code http://purl.org/ontology/bibo/handle}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/handle">handle</a>
	 */
	public static final URI handle;

	/**
	 * Hearing
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Hearing}.
	 * <p>
	 * An instance or a session in which testimony and arguments are
	 * presented, esp. before an official, as a judge in a lawsuit.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Hearing">Hearing</a>
	 */
	public static final URI Hearing;

	/**
	 * {@code http://purl.org/ontology/bibo/identifier}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/identifier">identifier</a>
	 */
	public static final URI identifier;

	/**
	 * Image
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Image}.
	 * <p>
	 * A document that presents visual or diagrammatic information.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Image">Image</a>
	 */
	public static final URI Image;

	/**
	 * Interview
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Interview}.
	 * <p>
	 * A formalized discussion between two or more people.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Interview">Interview</a>
	 */
	public static final URI Interview;

	/**
	 * interviewee
	 * <p>
	 * {@code http://purl.org/ontology/bibo/interviewee}.
	 * <p>
	 * An agent that is interviewed by another agent.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/interviewee">interviewee</a>
	 */
	public static final URI interviewee;

	/**
	 * interviewer
	 * <p>
	 * {@code http://purl.org/ontology/bibo/interviewer}.
	 * <p>
	 * An agent that interview another agent.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/interviewer">interviewer</a>
	 */
	public static final URI interviewer;

	/**
	 * {@code http://purl.org/ontology/bibo/isbn}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/isbn">isbn</a>
	 */
	public static final URI isbn;

	/**
	 * {@code http://purl.org/ontology/bibo/isbn10}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/isbn10">isbn10</a>
	 */
	public static final URI isbn10;

	/**
	 * {@code http://purl.org/ontology/bibo/isbn13}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/isbn13">isbn13</a>
	 */
	public static final URI isbn13;

	/**
	 * {@code http://purl.org/ontology/bibo/issn}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/issn">issn</a>
	 */
	public static final URI issn;

	/**
	 * Issue
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Issue}.
	 * <p>
	 * something that is printed or published and distributed, esp. a given
	 * number of a periodical
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Issue">Issue</a>
	 */
	public static final URI Issue;

	/**
	 * issue
	 * <p>
	 * {@code http://purl.org/ontology/bibo/issue}.
	 * <p>
	 * An issue number
	 *
	 * @see <a href="http://purl.org/ontology/bibo/issue">issue</a>
	 */
	public static final URI issue;

	/**
	 * issuer
	 * <p>
	 * {@code http://purl.org/ontology/bibo/issuer}.
	 * <p>
	 * An entity responsible for issuing often informally published documents
	 * such as press releases, reports, etc.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/issuer">issuer</a>
	 */
	public static final URI issuer;

	/**
	 * Journal
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Journal}.
	 * <p>
	 * A periodical of scholarly journal Articles.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Journal">Journal</a>
	 */
	public static final URI Journal;

	/**
	 * {@code http://purl.org/ontology/bibo/lccn}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/lccn">lccn</a>
	 */
	public static final URI lccn;

	/**
	 * Legal Case Document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/LegalCaseDocument}.
	 * <p>
	 * A document accompanying a legal case.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/LegalCaseDocument">LegalCaseDocument</a>
	 */
	public static final URI LegalCaseDocument;

	/**
	 * Decision
	 * <p>
	 * {@code http://purl.org/ontology/bibo/LegalDecision}.
	 * <p>
	 * A document containing an authoritative determination (as a decree or
	 * judgment) made after consideration of facts or law.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/LegalDecision">LegalDecision</a>
	 */
	public static final URI LegalDecision;

	/**
	 * Legal Document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/LegalDocument}.
	 * <p>
	 * A legal document; for example, a court decision, a brief, and so
	 * forth.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/LegalDocument">LegalDocument</a>
	 */
	public static final URI LegalDocument;

	/**
	 * Legislation
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Legislation}.
	 * <p>
	 * A legal document proposing or enacting a law or a group of laws.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Legislation">Legislation</a>
	 */
	public static final URI Legislation;

	/**
	 * Letter
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Letter}.
	 * <p>
	 * A written or printed communication addressed to a person or
	 * organization and usually transmitted by mail.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Letter">Letter</a>
	 */
	public static final URI Letter;

	/**
	 * locator
	 * <p>
	 * {@code http://purl.org/ontology/bibo/locator}.
	 * <p>
	 * A description (often numeric) that locates an item within a containing
	 * document or collection.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/locator">locator</a>
	 */
	public static final URI locator;

	/**
	 * Magazine
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Magazine}.
	 * <p>
	 * A periodical of magazine Articles. A magazine is a publication that is
	 * issued periodically, usually bound in a paper cover, and typically
	 * contains essays, stories, poems, etc., by many writers, and often
	 * photographs and drawings, frequently specializing in a particular
	 * subject or area, as hobbies, news, or sports.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Magazine">Magazine</a>
	 */
	public static final URI Magazine;

	/**
	 * Manual
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Manual}.
	 * <p>
	 * A small reference book, especially one giving instructions.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Manual">Manual</a>
	 */
	public static final URI Manual;

	/**
	 * Manuscript
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Manuscript}.
	 * <p>
	 * An unpublished Document, which may also be submitted to a publisher
	 * for publication.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Manuscript">Manuscript</a>
	 */
	public static final URI Manuscript;

	/**
	 * Map
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Map}.
	 * <p>
	 * A graphical depiction of geographic features.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Map">Map</a>
	 */
	public static final URI Map;

	/**
	 * Series
	 * <p>
	 * {@code http://purl.org/ontology/bibo/MultiVolumeBook}.
	 * <p>
	 * A loose, thematic, collection of Documents, often Books.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/MultiVolumeBook">MultiVolumeBook</a>
	 */
	public static final URI MultiVolumeBook;

	/**
	 * Newspaper
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Newspaper}.
	 * <p>
	 * A periodical of documents, usually issued daily or weekly, containing
	 * current news, editorials, feature articles, and usually advertising.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Newspaper">Newspaper</a>
	 */
	public static final URI Newspaper;

	/**
	 * Note
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Note}.
	 * <p>
	 * Notes or annotations about a resource.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Note">Note</a>
	 */
	public static final URI Note;

	/**
	 * number
	 * <p>
	 * {@code http://purl.org/ontology/bibo/number}.
	 * <p>
	 * A generic item or document number. Not to be confused with issue
	 * number.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/number">number</a>
	 */
	public static final URI number;

	/**
	 * number of pages
	 * <p>
	 * {@code http://purl.org/ontology/bibo/numPages}.
	 * <p>
	 * The number of pages contained in a document
	 *
	 * @see <a href="http://purl.org/ontology/bibo/numPages">numPages</a>
	 */
	public static final URI numPages;

	/**
	 * number of volumes
	 * <p>
	 * {@code http://purl.org/ontology/bibo/numVolumes}.
	 * <p>
	 * The number of volumes contained in a collection of documents (usually
	 * a series, periodical, etc.).
	 *
	 * @see <a href="http://purl.org/ontology/bibo/numVolumes">numVolumes</a>
	 */
	public static final URI numVolumes;

	/**
	 * {@code http://purl.org/ontology/bibo/oclcnum}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/oclcnum">oclcnum</a>
	 */
	public static final URI oclcnum;

	/**
	 * organizer
	 * <p>
	 * {@code http://purl.org/ontology/bibo/organizer}.
	 * <p>
	 * The organizer of an event; includes conference organizers, but also
	 * government agencies or other bodies that are responsible for
	 * conducting hearings.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/organizer">organizer</a>
	 */
	public static final URI organizer;

	/**
	 * owner
	 * <p>
	 * {@code http://purl.org/ontology/bibo/owner}.
	 * <p>
	 * Owner of a document or a collection of documents.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/owner">owner</a>
	 */
	public static final URI owner;

	/**
	 * page end
	 * <p>
	 * {@code http://purl.org/ontology/bibo/pageEnd}.
	 * <p>
	 * Ending page number within a continuous page range.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/pageEnd">pageEnd</a>
	 */
	public static final URI pageEnd;

	/**
	 * pages
	 * <p>
	 * {@code http://purl.org/ontology/bibo/pages}.
	 * <p>
	 * A string of non-contiguous page spans that locate a Document within a
	 * Collection. Example: 23-25, 34, 54-56. For continuous page ranges, use
	 * the pageStart and pageEnd properties.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/pages">pages</a>
	 */
	public static final URI pages;

	/**
	 * page start
	 * <p>
	 * {@code http://purl.org/ontology/bibo/pageStart}.
	 * <p>
	 * Starting page number within a continuous page range.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/pageStart">pageStart</a>
	 */
	public static final URI pageStart;

	/**
	 * Patent
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Patent}.
	 * <p>
	 * A document describing the exclusive right granted by a government to
	 * an inventor to manufacture, use, or sell an invention for a certain
	 * number of years.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Patent">Patent</a>
	 */
	public static final URI Patent;

	/**
	 * Performance
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Performance}.
	 * <p>
	 * A public performance.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Performance">Performance</a>
	 */
	public static final URI Performance;

	/**
	 * performer
	 * <p>
	 * {@code http://purl.org/ontology/bibo/performer}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/performer">performer</a>
	 */
	public static final URI performer;

	/**
	 * Periodical
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Periodical}.
	 * <p>
	 * A group of related documents issued at regular intervals.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Periodical">Periodical</a>
	 */
	public static final URI Periodical;

	/**
	 * Personal Communication
	 * <p>
	 * {@code http://purl.org/ontology/bibo/PersonalCommunication}.
	 * <p>
	 * A communication between an agent and one or more specific recipients.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/PersonalCommunication">PersonalCommunication</a>
	 */
	public static final URI PersonalCommunication;

	/**
	 * Personal Communication Document
	 * <p>
	 * {@code http://purl.org/ontology/bibo/PersonalCommunicationDocument}.
	 * <p>
	 * A personal communication manifested in some document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/PersonalCommunicationDocument">PersonalCommunicationDocument</a>
	 */
	public static final URI PersonalCommunicationDocument;

	/**
	 * {@code http://purl.org/ontology/bibo/pmid}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/pmid">pmid</a>
	 */
	public static final URI pmid;

	/**
	 * prefix name
	 * <p>
	 * {@code http://purl.org/ontology/bibo/prefixName}.
	 * <p>
	 * The prefix of a name
	 *
	 * @see <a href="http://purl.org/ontology/bibo/prefixName">prefixName</a>
	 */
	public static final URI prefixName;

	/**
	 * presented at
	 * <p>
	 * {@code http://purl.org/ontology/bibo/presentedAt}.
	 * <p>
	 * Relates a document to an event; for example, a paper to a conference.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/presentedAt">presentedAt</a>
	 */
	public static final URI presentedAt;

	/**
	 * presented at
	 * <p>
	 * {@code http://purl.org/ontology/bibo/presents}.
	 * <p>
	 * Relates an event to associated documents; for example, conference to a
	 * paper.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/presents">presents</a>
	 */
	public static final URI presents;

	/**
	 * Proceedings
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Proceedings}.
	 * <p>
	 * A compilation of documents published from an event, such as a
	 * conference.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Proceedings">Proceedings</a>
	 */
	public static final URI Proceedings;

	/**
	 * producer
	 * <p>
	 * {@code http://purl.org/ontology/bibo/producer}.
	 * <p>
	 * Producer of a document or a collection of documents.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/producer">producer</a>
	 */
	public static final URI producer;

	/**
	 * Quote
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Quote}.
	 * <p>
	 * An excerpted collection of words.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Quote">Quote</a>
	 */
	public static final URI Quote;

	/**
	 * recipient
	 * <p>
	 * {@code http://purl.org/ontology/bibo/recipient}.
	 * <p>
	 * An agent that receives a communication document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/recipient">recipient</a>
	 */
	public static final URI recipient;

	/**
	 * Reference Source
	 * <p>
	 * {@code http://purl.org/ontology/bibo/ReferenceSource}.
	 * <p>
	 * A document that presents authoritative reference information, such as
	 * a dictionary or encylopedia .
	 *
	 * @see <a href="http://purl.org/ontology/bibo/ReferenceSource">ReferenceSource</a>
	 */
	public static final URI ReferenceSource;

	/**
	 * Report
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Report}.
	 * <p>
	 * A document describing an account or statement describing in detail an
	 * event, situation, or the like, usually as the result of observation,
	 * inquiry, etc..
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Report">Report</a>
	 */
	public static final URI Report;

	/**
	 * {@code http://purl.org/ontology/bibo/reproducedIn}.
	 * <p>
	 * The resource in which another resource is reproduced.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/reproducedIn">reproducedIn</a>
	 */
	public static final URI reproducedIn;

	/**
	 * {@code http://purl.org/ontology/bibo/reversedBy}.
	 * <p>
	 * A legal decision that reverses a ruling.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/reversedBy">reversedBy</a>
	 */
	public static final URI reversedBy;

	/**
	 * review of
	 * <p>
	 * {@code http://purl.org/ontology/bibo/reviewOf}.
	 * <p>
	 * Relates a review document to a reviewed thing (resource, item, etc.).
	 *
	 * @see <a href="http://purl.org/ontology/bibo/reviewOf">reviewOf</a>
	 */
	public static final URI reviewOf;

	/**
	 * section
	 * <p>
	 * {@code http://purl.org/ontology/bibo/section}.
	 * <p>
	 * A section number
	 *
	 * @see <a href="http://purl.org/ontology/bibo/section">section</a>
	 */
	public static final URI section;

	/**
	 * Series
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Series}.
	 * <p>
	 * A loose, thematic, collection of Documents, often Books.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Series">Series</a>
	 */
	public static final URI Series;

	/**
	 * {@code http://purl.org/ontology/bibo/shortDescription}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/shortDescription">shortDescription</a>
	 */
	public static final URI shortDescription;

	/**
	 * short title
	 * <p>
	 * {@code http://purl.org/ontology/bibo/shortTitle}.
	 * <p>
	 * The abbreviation of a title.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/shortTitle">shortTitle</a>
	 */
	public static final URI shortTitle;

	/**
	 * {@code http://purl.org/ontology/bibo/sici}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/sici">sici</a>
	 */
	public static final URI sici;

	/**
	 * Slide
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Slide}.
	 * <p>
	 * A slide in a slideshow
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Slide">Slide</a>
	 */
	public static final URI Slide;

	/**
	 * Slideshow
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Slideshow}.
	 * <p>
	 * A presentation of a series of slides, usually presented in front of an
	 * audience with written text and images.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Slideshow">Slideshow</a>
	 */
	public static final URI Slideshow;

	/**
	 * Standard
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Standard}.
	 * <p>
	 * A document describing a standard
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Standard">Standard</a>
	 */
	public static final URI Standard;

	/**
	 * status
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status}.
	 * <p>
	 * The publication status of (typically academic) content.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status">status</a>
	 */
	public static final URI status;

	/**
	 * accepted
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/accepted}.
	 * <p>
	 * Accepted for publication after peer reviewing.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/accepted">status/accepted</a>
	 */
	public static final URI status_accepted;

	/**
	 * draft
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/draft}.
	 * <p>
	 * Document drafted
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/draft">status/draft</a>
	 */
	public static final URI status_draft;

	/**
	 * forthcoming
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/forthcoming}.
	 * <p>
	 * Document to be published
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/forthcoming">status/forthcoming</a>
	 */
	public static final URI status_forthcoming;

	/**
	 * legal
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/legal}.
	 * <p>
	 * Legal document
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/legal">status/legal</a>
	 */
	public static final URI status_legal;

	/**
	 * non peer reviewed
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/nonPeerReviewed}.
	 * <p>
	 * A document that is not peer reviewed
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/nonPeerReviewed">status/nonPeerReviewed</a>
	 */
	public static final URI status_nonPeerReviewed;

	/**
	 * peer reviewed
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/peerReviewed}.
	 * <p>
	 * The process by which articles are chosen to be included in a refereed
	 * journal. An editorial board consisting of experts in the same field as
	 * the author review the article and decide if it is authoritative enough
	 * for publication.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/peerReviewed">status/peerReviewed</a>
	 */
	public static final URI status_peerReviewed;

	/**
	 * published
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/published}.
	 * <p>
	 * Published document
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/published">status/published</a>
	 */
	public static final URI status_published;

	/**
	 * rejected
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/rejected}.
	 * <p>
	 * Rejected for publication after peer reviewing.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/rejected">status/rejected</a>
	 */
	public static final URI status_rejected;

	/**
	 * unpublished
	 * <p>
	 * {@code http://purl.org/ontology/bibo/status/unpublished}.
	 * <p>
	 * Unpublished document
	 *
	 * @see <a href="http://purl.org/ontology/bibo/status/unpublished">status/unpublished</a>
	 */
	public static final URI status_unpublished;

	/**
	 * Statute
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Statute}.
	 * <p>
	 * A bill enacted into law.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Statute">Statute</a>
	 */
	public static final URI Statute;

	/**
	 * {@code http://purl.org/ontology/bibo/subsequentLegalDecision}.
	 * <p>
	 * A legal decision on appeal that takes action on a case (affirming it,
	 * reversing it, etc.).
	 *
	 * @see <a href="http://purl.org/ontology/bibo/subsequentLegalDecision">subsequentLegalDecision</a>
	 */
	public static final URI subsequentLegalDecision;

	/**
	 * suffix name
	 * <p>
	 * {@code http://purl.org/ontology/bibo/suffixName}.
	 * <p>
	 * The suffix of a name
	 *
	 * @see <a href="http://purl.org/ontology/bibo/suffixName">suffixName</a>
	 */
	public static final URI suffixName;

	/**
	 * Thesis
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Thesis}.
	 * <p>
	 * A document created to summarize research findings associated with the
	 * completion of an academic degree.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Thesis">Thesis</a>
	 */
	public static final URI Thesis;

	/**
	 * Thesis degree
	 * <p>
	 * {@code http://purl.org/ontology/bibo/ThesisDegree}.
	 * <p>
	 * The academic degree of a Thesis
	 *
	 * @see <a href="http://purl.org/ontology/bibo/ThesisDegree">ThesisDegree</a>
	 */
	public static final URI ThesisDegree;

	/**
	 * transcript of
	 * <p>
	 * {@code http://purl.org/ontology/bibo/transcriptOf}.
	 * <p>
	 * Relates a document to some transcribed original.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/transcriptOf">transcriptOf</a>
	 */
	public static final URI transcriptOf;

	/**
	 * translation of
	 * <p>
	 * {@code http://purl.org/ontology/bibo/translationOf}.
	 * <p>
	 * Relates a translated document to the original document.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/translationOf">translationOf</a>
	 */
	public static final URI translationOf;

	/**
	 * translator
	 * <p>
	 * {@code http://purl.org/ontology/bibo/translator}.
	 * <p>
	 * A person who translates written document from one language to another.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/translator">translator</a>
	 */
	public static final URI translator;

	/**
	 * {@code http://purl.org/ontology/bibo/upc}.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/upc">upc</a>
	 */
	public static final URI upc;

	/**
	 * uri
	 * <p>
	 * {@code http://purl.org/ontology/bibo/uri}.
	 * <p>
	 * Universal Resource Identifier of a document
	 *
	 * @see <a href="http://purl.org/ontology/bibo/uri">uri</a>
	 */
	public static final URI uri;

	/**
	 * volume
	 * <p>
	 * {@code http://purl.org/ontology/bibo/volume}.
	 * <p>
	 * A volume number
	 *
	 * @see <a href="http://purl.org/ontology/bibo/volume">volume</a>
	 */
	public static final URI volume;

	/**
	 * Webpage
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Webpage}.
	 * <p>
	 * A web page is an online document available (at least initially) on the
	 * world wide web. A web page is written first and foremost to appear on
	 * the web, as distinct from other online resources such as books,
	 * manuscripts or audio documents which use the web primarily as a
	 * distribution mechanism alongside other more traditional methods such
	 * as print.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Webpage">Webpage</a>
	 */
	public static final URI Webpage;

	/**
	 * Website
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Website}.
	 * <p>
	 * A group of Webpages accessible on the Web.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Website">Website</a>
	 */
	public static final URI Website;

	/**
	 * Workshop
	 * <p>
	 * {@code http://purl.org/ontology/bibo/Workshop}.
	 * <p>
	 * A seminar, discussion group, or the like, that emphasizes zxchange of
	 * ideas and the demonstration and application of techniques, skills,
	 * etc.
	 *
	 * @see <a href="http://purl.org/ontology/bibo/Workshop">Workshop</a>
	 */
	public static final URI Workshop;

	static {
		ValueFactory factory = ValueFactoryImpl.getInstance();

		_abstract = factory.createURI(BIBO.NAMESPACE, "abstract");
		AcademicArticle = factory.createURI(BIBO.NAMESPACE, "AcademicArticle");
		affirmedBy = factory.createURI(BIBO.NAMESPACE, "affirmedBy");
		annotates = factory.createURI(BIBO.NAMESPACE, "annotates");
		argued = factory.createURI(BIBO.NAMESPACE, "argued");
		Article = factory.createURI(BIBO.NAMESPACE, "Article");
		asin = factory.createURI(BIBO.NAMESPACE, "asin");
		AudioDocument = factory.createURI(BIBO.NAMESPACE, "AudioDocument");
		AudioVisualDocument = factory.createURI(BIBO.NAMESPACE, "AudioVisualDocument");
		authorList = factory.createURI(BIBO.NAMESPACE, "authorList");
		bdarcus = factory.createURI(BIBO.NAMESPACE, "bdarcus");
		Bill = factory.createURI(BIBO.NAMESPACE, "Bill");
		Book = factory.createURI(BIBO.NAMESPACE, "Book");
		BookSection = factory.createURI(BIBO.NAMESPACE, "BookSection");
		Brief = factory.createURI(BIBO.NAMESPACE, "Brief");
		chapter = factory.createURI(BIBO.NAMESPACE, "chapter");
		Chapter = factory.createURI(BIBO.NAMESPACE, "Chapter");
		citedBy = factory.createURI(BIBO.NAMESPACE, "citedBy");
		cites = factory.createURI(BIBO.NAMESPACE, "cites");
		Code = factory.createURI(BIBO.NAMESPACE, "Code");
		coden = factory.createURI(BIBO.NAMESPACE, "coden");
		CollectedDocument = factory.createURI(BIBO.NAMESPACE, "CollectedDocument");
		Collection = factory.createURI(BIBO.NAMESPACE, "Collection");
		Conference = factory.createURI(BIBO.NAMESPACE, "Conference");
		content = factory.createURI(BIBO.NAMESPACE, "content");
		contributorList = factory.createURI(BIBO.NAMESPACE, "contributorList");
		court = factory.createURI(BIBO.NAMESPACE, "court");
		CourtReporter = factory.createURI(BIBO.NAMESPACE, "CourtReporter");
		degree = factory.createURI(BIBO.NAMESPACE, "degree");
		degrees_ma = factory.createURI(BIBO.NAMESPACE, "degrees/ma");
		degrees_ms = factory.createURI(BIBO.NAMESPACE, "degrees/ms");
		degrees_phd = factory.createURI(BIBO.NAMESPACE, "degrees/phd");
		director = factory.createURI(BIBO.NAMESPACE, "director");
		distributor = factory.createURI(BIBO.NAMESPACE, "distributor");
		Document = factory.createURI(BIBO.NAMESPACE, "Document");
		DocumentPart = factory.createURI(BIBO.NAMESPACE, "DocumentPart");
		DocumentStatus = factory.createURI(BIBO.NAMESPACE, "DocumentStatus");
		doi = factory.createURI(BIBO.NAMESPACE, "doi");
		eanucc13 = factory.createURI(BIBO.NAMESPACE, "eanucc13");
		EditedBook = factory.createURI(BIBO.NAMESPACE, "EditedBook");
		edition = factory.createURI(BIBO.NAMESPACE, "edition");
		editor = factory.createURI(BIBO.NAMESPACE, "editor");
		editorList = factory.createURI(BIBO.NAMESPACE, "editorList");
		eissn = factory.createURI(BIBO.NAMESPACE, "eissn");
		Email = factory.createURI(BIBO.NAMESPACE, "Email");
		Event = factory.createURI(BIBO.NAMESPACE, "Event");
		Excerpt = factory.createURI(BIBO.NAMESPACE, "Excerpt");
		fgiasson = factory.createURI(BIBO.NAMESPACE, "fgiasson");
		Film = factory.createURI(BIBO.NAMESPACE, "Film");
		gtin14 = factory.createURI(BIBO.NAMESPACE, "gtin14");
		handle = factory.createURI(BIBO.NAMESPACE, "handle");
		Hearing = factory.createURI(BIBO.NAMESPACE, "Hearing");
		identifier = factory.createURI(BIBO.NAMESPACE, "identifier");
		Image = factory.createURI(BIBO.NAMESPACE, "Image");
		Interview = factory.createURI(BIBO.NAMESPACE, "Interview");
		interviewee = factory.createURI(BIBO.NAMESPACE, "interviewee");
		interviewer = factory.createURI(BIBO.NAMESPACE, "interviewer");
		isbn = factory.createURI(BIBO.NAMESPACE, "isbn");
		isbn10 = factory.createURI(BIBO.NAMESPACE, "isbn10");
		isbn13 = factory.createURI(BIBO.NAMESPACE, "isbn13");
		issn = factory.createURI(BIBO.NAMESPACE, "issn");
		Issue = factory.createURI(BIBO.NAMESPACE, "Issue");
		issue = factory.createURI(BIBO.NAMESPACE, "issue");
		issuer = factory.createURI(BIBO.NAMESPACE, "issuer");
		Journal = factory.createURI(BIBO.NAMESPACE, "Journal");
		lccn = factory.createURI(BIBO.NAMESPACE, "lccn");
		LegalCaseDocument = factory.createURI(BIBO.NAMESPACE, "LegalCaseDocument");
		LegalDecision = factory.createURI(BIBO.NAMESPACE, "LegalDecision");
		LegalDocument = factory.createURI(BIBO.NAMESPACE, "LegalDocument");
		Legislation = factory.createURI(BIBO.NAMESPACE, "Legislation");
		Letter = factory.createURI(BIBO.NAMESPACE, "Letter");
		locator = factory.createURI(BIBO.NAMESPACE, "locator");
		Magazine = factory.createURI(BIBO.NAMESPACE, "Magazine");
		Manual = factory.createURI(BIBO.NAMESPACE, "Manual");
		Manuscript = factory.createURI(BIBO.NAMESPACE, "Manuscript");
		Map = factory.createURI(BIBO.NAMESPACE, "Map");
		MultiVolumeBook = factory.createURI(BIBO.NAMESPACE, "MultiVolumeBook");
		Newspaper = factory.createURI(BIBO.NAMESPACE, "Newspaper");
		Note = factory.createURI(BIBO.NAMESPACE, "Note");
		number = factory.createURI(BIBO.NAMESPACE, "number");
		numPages = factory.createURI(BIBO.NAMESPACE, "numPages");
		numVolumes = factory.createURI(BIBO.NAMESPACE, "numVolumes");
		oclcnum = factory.createURI(BIBO.NAMESPACE, "oclcnum");
		organizer = factory.createURI(BIBO.NAMESPACE, "organizer");
		owner = factory.createURI(BIBO.NAMESPACE, "owner");
		pageEnd = factory.createURI(BIBO.NAMESPACE, "pageEnd");
		pages = factory.createURI(BIBO.NAMESPACE, "pages");
		pageStart = factory.createURI(BIBO.NAMESPACE, "pageStart");
		Patent = factory.createURI(BIBO.NAMESPACE, "Patent");
		Performance = factory.createURI(BIBO.NAMESPACE, "Performance");
		performer = factory.createURI(BIBO.NAMESPACE, "performer");
		Periodical = factory.createURI(BIBO.NAMESPACE, "Periodical");
		PersonalCommunication = factory.createURI(BIBO.NAMESPACE, "PersonalCommunication");
		PersonalCommunicationDocument = factory.createURI(BIBO.NAMESPACE, "PersonalCommunicationDocument");
		pmid = factory.createURI(BIBO.NAMESPACE, "pmid");
		prefixName = factory.createURI(BIBO.NAMESPACE, "prefixName");
		presentedAt = factory.createURI(BIBO.NAMESPACE, "presentedAt");
		presents = factory.createURI(BIBO.NAMESPACE, "presents");
		Proceedings = factory.createURI(BIBO.NAMESPACE, "Proceedings");
		producer = factory.createURI(BIBO.NAMESPACE, "producer");
		Quote = factory.createURI(BIBO.NAMESPACE, "Quote");
		recipient = factory.createURI(BIBO.NAMESPACE, "recipient");
		ReferenceSource = factory.createURI(BIBO.NAMESPACE, "ReferenceSource");
		Report = factory.createURI(BIBO.NAMESPACE, "Report");
		reproducedIn = factory.createURI(BIBO.NAMESPACE, "reproducedIn");
		reversedBy = factory.createURI(BIBO.NAMESPACE, "reversedBy");
		reviewOf = factory.createURI(BIBO.NAMESPACE, "reviewOf");
		section = factory.createURI(BIBO.NAMESPACE, "section");
		Series = factory.createURI(BIBO.NAMESPACE, "Series");
		shortDescription = factory.createURI(BIBO.NAMESPACE, "shortDescription");
		shortTitle = factory.createURI(BIBO.NAMESPACE, "shortTitle");
		sici = factory.createURI(BIBO.NAMESPACE, "sici");
		Slide = factory.createURI(BIBO.NAMESPACE, "Slide");
		Slideshow = factory.createURI(BIBO.NAMESPACE, "Slideshow");
		Standard = factory.createURI(BIBO.NAMESPACE, "Standard");
		status = factory.createURI(BIBO.NAMESPACE, "status");
		status_accepted = factory.createURI(BIBO.NAMESPACE, "status/accepted");
		status_draft = factory.createURI(BIBO.NAMESPACE, "status/draft");
		status_forthcoming = factory.createURI(BIBO.NAMESPACE, "status/forthcoming");
		status_legal = factory.createURI(BIBO.NAMESPACE, "status/legal");
		status_nonPeerReviewed = factory.createURI(BIBO.NAMESPACE, "status/nonPeerReviewed");
		status_peerReviewed = factory.createURI(BIBO.NAMESPACE, "status/peerReviewed");
		status_published = factory.createURI(BIBO.NAMESPACE, "status/published");
		status_rejected = factory.createURI(BIBO.NAMESPACE, "status/rejected");
		status_unpublished = factory.createURI(BIBO.NAMESPACE, "status/unpublished");
		Statute = factory.createURI(BIBO.NAMESPACE, "Statute");
		subsequentLegalDecision = factory.createURI(BIBO.NAMESPACE, "subsequentLegalDecision");
		suffixName = factory.createURI(BIBO.NAMESPACE, "suffixName");
		Thesis = factory.createURI(BIBO.NAMESPACE, "Thesis");
		ThesisDegree = factory.createURI(BIBO.NAMESPACE, "ThesisDegree");
		transcriptOf = factory.createURI(BIBO.NAMESPACE, "transcriptOf");
		translationOf = factory.createURI(BIBO.NAMESPACE, "translationOf");
		translator = factory.createURI(BIBO.NAMESPACE, "translator");
		upc = factory.createURI(BIBO.NAMESPACE, "upc");
		uri = factory.createURI(BIBO.NAMESPACE, "uri");
		volume = factory.createURI(BIBO.NAMESPACE, "volume");
		Webpage = factory.createURI(BIBO.NAMESPACE, "Webpage");
		Website = factory.createURI(BIBO.NAMESPACE, "Website");
		Workshop = factory.createURI(BIBO.NAMESPACE, "Workshop");
	}

	private BIBO() {
		//static access only
	}

}
