package org.fit.layout.eswc.vocabulary;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * Semantic Web Conference Ontology.
 * <p>
 * Namespace SWC.
 * Prefix: {@code <http://data.semanticweb.org/ns/swc/ontology>}
 */
public class SWC {

	/** {@code http://data.semanticweb.org/ns/swc/ontology} **/
	public static final String NAMESPACE = "http://data.semanticweb.org/ns/swc/ontology";

	/** {@code swc} **/
	public static final String PREFIX = "swc";

	/**
	 * Introduction
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#01_introduction}.
	 * <p>
	 * <p> The Semantic Web Conference ontology (SWC) is an ontology for
	 * describing academic conferences. It was initially designed to support
	 * the European Semantic Web Conference, ESWC2007, and later extended for
	 * both the following conferences in the ESWC series, as well as in the
	 * ISWC series. Historically, the SWC ontology also draws heavily on
	 * ontologies developed for ESWC2006 and ISWC2006. </p> <p> SWC is mainly
	 * a convention of how to use classes and properties from other
	 * ontologies, most prominently <a
	 * href="http://xmlns.com/foaf/0.1">FOAF</a> (for people) and <a
	 * href="http://ontoware.org/projects/swrc/">SWRC</a> (their BibTeX
	 * elements, for the papers). We are also throwing in some <a
	 * href="http://sioc-project.org/">SIOC</a>, <a
	 * href="http://dublincore.org/documents/dc-rdf/index.shtml">Dublin
	 * Core</a> and <a href="http://www.w3.org/TR/rdfcal/">iCal/RDF
	 * Calendar</a>. Our own <a
	 * href="http://data.semanticweb.org/ns/swc/ontology">swc namespace</a>
	 * provides the glue for all this, as well as specialised classes for
	 * things that have to do with conferences. </p> <p> This version of SWC
	 * has been slimmed down significantly (hence the revision name). A total
	 * of 59 classes and 19 properties have been deprecated (deprecated terms
	 * can be found at the bottom of this document). This was mostly done
	 * with the intention to remove the countless sub-classes of generic
	 * classes such as <a href="#Chair">Chair</a> or <a
	 * href="#SessionEvent">SessionEvent</a>, which were deemed to be too
	 * specific for a general-purpose conference ontology such as SWC.
	 * Elsewhere, classes and properties which had never been used and seemed
	 * to fall under the heading of "over-engineering" were removed. Finally,
	 * all CfP related terms were removed. Instead, we suggest to use a
	 * dedicated ontology such as the <a
	 * href="http://sw.deri.org/2005/08/conf/cfp">CfP ontology</a>. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#01_introduction">#01_introduction</a>
	 */
	public static final URI x01_introduction;

	/**
	 * Describing Papers
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#02_describing_papers}.
	 * <p>
	 * <p>For the basic use case of describing papers, the figure below shows
	 * how the main kinds of resources are connected: the paper itself, the
	 * authors and their affiliations, and the talk where the paper was
	 * presented. </p> <div align="center"> <a
	 * href="documentation/20070921-ISWC+ASWC2007PublicationGraph.pdf"><img
	 * src="documentation/20070921-ISWC+ASWC2007PublicationGraph.png" /></a>
	 * </div> <p> The next figure shows in more detail the kinds of things
	 * that can be said about each of the four main entities surrounding a
	 * paper. </p> <div align="center"> <a
	 * href="documentation/20071002-Properties.pdf"><img
	 * src="documentation/20071002-Properties.png" /></a> </div>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#02_describing_papers">#02_describing_papers</a>
	 */
	public static final URI x02_describing_papers;

	/**
	 * Roles
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#03_roles}.
	 * <p>
	 * <p> One of the basic design choices in SWC is to use role modelling
	 * for describing the different functions at a conference, such as
	 * chairs, reviewers, etc. For any particular role at a given conference,
	 * the <code>swc:Role</code> class or a sub-class will be instantiated.
	 * This role instance stands in relation to a person (who plays the role)
	 * and an event. The figure below gives an example showing how to model
	 * the role of the metadata chair (or "dog food tsar") at ISWC+ASWC2007,
	 * which was held by Knud Möller (together with Tom Heath, not shown in
	 * the figure). </p> <p> Note that the metadata chair role is not
	 * modelled with its own dedicated class (although it could have been).
	 * Instead, an instance of the generic <a href="#Chair">Chair</a> class
	 * is used and labelled accordingly. </p> <div align="center"> <a
	 * href="documentation/20090510-Roles_new.pdf"><img
	 * src="documentation/20090510-Roles_new.png" /></a> </div>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#03_roles">#03_roles</a>
	 */
	public static final URI x03_roles;

	/**
	 * Academic Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#AcademicEvent}.
	 * <p>
	 * <p>Academic events are e.g. conferences and conference-like events,
	 * and all the sub-events of those which are about the topic or theme of
	 * the conference, such as talks or panels.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#AcademicEvent">#AcademicEvent</a>
	 */
	public static final URI AcademicEvent;

	/**
	 * Accommodation Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#AccommodationPlace}.
	 * <p>
	 * <p> A hotel, hostel, BnB or similar. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#AccommodationPlace">#AccommodationPlace</a>
	 */
	public static final URI AccommodationPlace;

	/**
	 * Additional Reviewer
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#AdditionalReviewer}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#AdditionalReviewer">#AdditionalReviewer</a>
	 */
	public static final URI AdditionalReviewer;

	/**
	 * Administrator
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Administrator}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Administrator">#Administrator</a>
	 */
	public static final URI Administrator;

	/**
	 * affiliation
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#affiliation}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#affiliation">#affiliation</a>
	 */
	public static final URI affiliation;

	/**
	 * Argumentative Document
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ArgumentativeDocument}.
	 * <p>
	 * <p>An argumentative document is a document which uses analytical
	 * reasoning and evidence in order to argue for a point of view. Typical
	 * examples are scientific papers or political pamphlets. Negative
	 * examples are novels or plays (even though a novel might also try to
	 * sway the reader to a certain point of view).</p> <p>According to <a
	 * href="http://en.wikipedia.org/wiki/Text_types">Text Types</a>, an
	 * argumentative document is based "on the evaluation and the subsequent
	 * subjective judgement in answer to a problem. It refers to the reasons
	 * advanced for or against a matter".</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ArgumentativeDocument">#ArgumentativeDocument</a>
	 */
	public static final URI ArgumentativeDocument;

	/**
	 * Artefact
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Artefact}.
	 * <p>
	 * <p><emph>Artefact</emph> here means a document which can have a
	 * physical manifestation, like a paper or the proceedings of a
	 * conference.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Artefact">#Artefact</a>
	 */
	public static final URI Artefact;

	/**
	 * attendee at
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#attendeeAt}.
	 * <p>
	 * <p>Instead of this property, use the <a href="#Delegate">Delegate</a>
	 * role.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#attendeeAt">#attendeeAt</a>
	 */
	public static final URI attendeeAt;

	/**
	 * bibliographic reference
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#biblioReference}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#biblioReference">#biblioReference</a>
	 */
	public static final URI biblioReference;

	/**
	 * Break Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#BreakEvent}.
	 * <p>
	 * <p> Any kind of break at the super-event, such as a coffee break. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#BreakEvent">#BreakEvent</a>
	 */
	public static final URI BreakEvent;

	/**
	 * Call
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Call}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p> <p>A <emph>call</emph> is a public announcement,
	 * asking for contribution of some kind to events such as conferences or
	 * workshops, or to a publication such as a journal or book.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Call">#Call</a>
	 */
	public static final URI Call;

	/**
	 * Call for Demos
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CallForDemos}.
	 * <p>
	 * <p>A call for demonstrations of software at a conference or workshop.
	 * Submissions are usually in the form of extended abstracts (~2 page)
	 * discussing the research questions addressed by the software and
	 * outlining the content of the demonstration.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CallForDemos">#CallForDemos</a>
	 */
	public static final URI CallForDemos;

	/**
	 * Call for Papers
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CallForPapers}.
	 * <p>
	 * <p>A <emph>call for papers</emph> or <emph>CfP</emph> encourages
	 * authors to submit papers for peer-review for a conference or workshop,
	 * or a journal or book.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CallForPapers">#CallForPapers</a>
	 */
	public static final URI CallForPapers;

	/**
	 * Call for Participation
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CallForParticipation}.
	 * <p>
	 * <p>This kind of call usually calls for potential delegates to attend
	 * an event such as a conference or a workshop.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CallForParticipation">#CallForParticipation</a>
	 */
	public static final URI CallForParticipation;

	/**
	 * Call for Posters
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CallForPosters}.
	 * <p>
	 * <p>A call for scientific posters at a conference or workshop.
	 * Submissions are usually in the form of extended abstracts (~2 page)
	 * discussing the research presented on the poster.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CallForPosters">#CallForPosters</a>
	 */
	public static final URI CallForPosters;

	/**
	 * Call for Proposals
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CallForProposals}.
	 * <p>
	 * <p>A call which asks for contributions in the form of e.g. workshop or
	 * tutorial proposals.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CallForProposals">#CallForProposals</a>
	 */
	public static final URI CallForProposals;

	/**
	 * Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Chair}.
	 * <p>
	 * <p> A sub-class of Role for various kinds of chair functions. Examples
	 * are the main chair of a conference, the tutorials chair, the
	 * proceedings chair, etc. Instead of introducing a large amount of
	 * sub-classes of Chair, we suggest to model all the different chair
	 * functions as instances of Chair with appropriate labels. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Chair">#Chair</a>
	 */
	public static final URI Chair;

	/**
	 * Coffee Break
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CoffeeBreak}.
	 * <p>
	 * Deprecating this - we can just use <a
	 * href="#BreakEvent">BreakEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CoffeeBreak">#CoffeeBreak</a>
	 */
	public static final URI CoffeeBreak;

	/**
	 * Communal Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#CommunalPlace}.
	 * <p>
	 * <p> A location at the <a href="#ConferenceVenuePlace">conference
	 * venue</a> (or elsewhere), which is not a meeting room. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#CommunalPlace">#CommunalPlace</a>
	 */
	public static final URI CommunalPlace;

	/**
	 * Conference Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ConferenceChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ConferenceChair">#ConferenceChair</a>
	 */
	public static final URI ConferenceChair;

	/**
	 * Closing Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ConferenceClosingEvent}.
	 * <p>
	 * Deprecating this - we can just use <a href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ConferenceClosingEvent">#ConferenceClosingEvent</a>
	 */
	public static final URI ConferenceClosingEvent;

	/**
	 * Conference Dinner
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ConferenceDinner}.
	 * <p>
	 * Deprecating this - we can just use <a
	 * href="#SocialEvent">SocialEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ConferenceDinner">#ConferenceDinner</a>
	 */
	public static final URI ConferenceDinner;

	/**
	 * Conference Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ConferenceEvent}.
	 * <p>
	 * <p> A scientific conference. </p> <p> TODO: Maybe this should be
	 * opened up - why only scientific conferences? </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ConferenceEvent">#ConferenceEvent</a>
	 */
	public static final URI ConferenceEvent;

	/**
	 * Opening Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ConferenceOpeningEvent}.
	 * <p>
	 * Deprecating this - we can just use <a href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ConferenceOpeningEvent">#ConferenceOpeningEvent</a>
	 */
	public static final URI ConferenceOpeningEvent;

	/**
	 * Conference Venue Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ConferenceVenuePlace}.
	 * <p>
	 * <p> The location of a conference or conference-like event. Ideally,
	 * this would be more specific than just the city. Instead it should be
	 * the hotel, convention centre, university or similar place where the
	 * event is held. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ConferenceVenuePlace">#ConferenceVenuePlace</a>
	 */
	public static final URI ConferenceVenuePlace;

	/**
	 * Delegate
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Delegate}.
	 * <p>
	 * <p> A delegate is someone who attends a conference or conference-like
	 * event. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Delegate">#Delegate</a>
	 */
	public static final URI Delegate;

	/**
	 * Demo Presentation
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#DemoPresentation}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#DemoPresentation">#DemoPresentation</a>
	 */
	public static final URI DemoPresentation;

	/**
	 * Demos Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#DemosChair}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#TrackChair">TrackChair</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#DemosChair">#DemosChair</a>
	 */
	public static final URI DemosChair;

	/**
	 * Demo Session
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#DemoSession}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#SessionEvent">SessionEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#DemoSession">#DemoSession</a>
	 */
	public static final URI DemoSession;

	/**
	 * Dogfood Tsar
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#DogfoodTsar}.
	 * <p>
	 * A role that is only relevant in relation to the topic of the
	 * conference e.g. Semantic Web Technologies Coordinator at a Semantic
	 * Web Conference.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#DogfoodTsar">#DogfoodTsar</a>
	 */
	public static final URI DogfoodTsar;

	/**
	 * Drinking Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#DrinkingPlace}.
	 * <p>
	 * <p>Deprecated to reduce inflation of terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#DrinkingPlace">#DrinkingPlace</a>
	 */
	public static final URI DrinkingPlace;

	/**
	 * Eating Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#EatingPlace}.
	 * <p>
	 * <p>Deprecated to reduce inflation of terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#EatingPlace">#EatingPlace</a>
	 */
	public static final URI EatingPlace;

	/**
	 * Excursion
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Excursion}.
	 * <p>
	 * Deprecating this - we can just use <a
	 * href="#SocialEvent">SocialEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Excursion">#Excursion</a>
	 */
	public static final URI Excursion;

	/**
	 * Exhibition Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ExhibitionChair}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#TrackChair">TrackChair</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ExhibitionChair">#ExhibitionChair</a>
	 */
	public static final URI ExhibitionChair;

	/**
	 * for event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#forEvent}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#forEvent">#forEvent</a>
	 */
	public static final URI forEvent;

	/**
	 * Free Time Break
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#FreeTimeBreak}.
	 * <p>
	 * Deprecating this - we can just use <a
	 * href="#BreakEvent">BreakEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#FreeTimeBreak">#FreeTimeBreak</a>
	 */
	public static final URI FreeTimeBreak;

	/**
	 * has attendee
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasAttendee}.
	 * <p>
	 * <p>Instead of this property, use the <a href="#Delegate">Delegate</a>
	 * role.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasAttendee">#hasAttendee</a>
	 */
	public static final URI hasAttendee;

	/**
	 * has call
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasCall}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasCall">#hasCall</a>
	 */
	public static final URI hasCall;

	/**
	 * has camera-ready deadline
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasCameraReadyDeadline}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasCameraReadyDeadline">#hasCameraReadyDeadline</a>
	 */
	public static final URI hasCameraReadyDeadline;

	/**
	 * has cost amount
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasCostAmount}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasCostAmount">#hasCostAmount</a>
	 */
	public static final URI hasCostAmount;

	/**
	 * has cost currency
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasCostCurrency}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasCostCurrency">#hasCostCurrency</a>
	 */
	public static final URI hasCostCurrency;

	/**
	 * has location
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasLocation}.
	 * <p>
	 * <p> Relates an event such as a conference or any sub-event thereof to
	 * a location where it takes place. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasLocation">#hasLocation</a>
	 */
	public static final URI hasLocation;

	/**
	 * has menu
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasMenu}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasMenu">#hasMenu</a>
	 */
	public static final URI hasMenu;

	/**
	 * has notification deadline
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasNotificationDeadline}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasNotificationDeadline">#hasNotificationDeadline</a>
	 */
	public static final URI hasNotificationDeadline;

	/**
	 * has part
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasPart}.
	 * <p>
	 * <p> A generic property to model part-of relationships. In SWC this
	 * property is used to relate a <a href="#Proceedings">proceedings
	 * document</a> to the papers and articles contained in it. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasPart">#hasPart</a>
	 */
	public static final URI hasPart;

	/**
	 * has programme
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasProgramme}.
	 * <p>
	 * <p> Relates an event such as a conference to its <a
	 * href="#Programme">Programme</a>. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasProgramme">#hasProgramme</a>
	 */
	public static final URI hasProgramme;

	/**
	 * has related artefact
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasRelatedArtefact}.
	 * <p>
	 * <p> Relates an <a href="#AcademicEvent">event</a> such as a
	 * conference, workshop, etc. to a physical <a
	 * href="#Artefact">artefact</a>. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasRelatedArtefact">#hasRelatedArtefact</a>
	 */
	public static final URI hasRelatedArtefact;

	/**
	 * has related document
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasRelatedDocument}.
	 * <p>
	 * <p> Relates an <a href="#AcademicEvent">event</a> such as a
	 * conference, workshop, etc. to a <a
	 * href="#ArgumentativeDocument">document</a>. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasRelatedDocument">#hasRelatedDocument</a>
	 */
	public static final URI hasRelatedDocument;

	/**
	 * has role
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasRole}.
	 * <p>
	 * <p> Part of the <a href="#Role">role</a> modelling machinery of SWC.
	 * This property relates an event (e.g. a conference) to a role at the
	 * event (e.g. a conference chair). </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasRole">#hasRole</a>
	 */
	public static final URI hasRole;

	/**
	 * has sponsorship
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasSponsorship}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasSponsorship">#hasSponsorship</a>
	 */
	public static final URI hasSponsorship;

	/**
	 * has submission deadline
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasSubmissionDeadline}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasSubmissionDeadline">#hasSubmissionDeadline</a>
	 */
	public static final URI hasSubmissionDeadline;

	/**
	 * has submission instructions
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasSubmissionInstructions}.
	 * <p>
	 * <p>The call classes have been deprecated in SWC. Instead, we suggest
	 * to use the <a href="http://sw.deri.org/2005/08/conf/cfp">CfP
	 * ontology</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasSubmissionInstructions">#hasSubmissionInstructions</a>
	 */
	public static final URI hasSubmissionInstructions;

	/**
	 * has topic
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#hasTopic}.
	 * <p>
	 * <p>Instead of this property, use <a
	 * href="http://xmlns.com/foaf/0.1/topic">foaf:topic</a>.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#hasTopic">#hasTopic</a>
	 */
	public static final URI hasTopic;

	/**
	 * held by
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#heldBy}.
	 * <p>
	 * <p> Part of the <a href="#Role">role</a> modelling machinery of SWC.
	 * This property relates a role at an event (e.g. a conference chair) to
	 * the person who actually holds the role. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#heldBy">#heldBy</a>
	 */
	public static final URI heldBy;

	/**
	 * holds role
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#holdsRole}.
	 * <p>
	 * <p> Part of the <a href="#Role">role</a> modelling machinery of SWC.
	 * This property relates a person to the role (e.g. a conference chair)
	 * it holds at an event. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#holdsRole">#holdsRole</a>
	 */
	public static final URI holdsRole;

	/**
	 * Industrial Talk
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#IndustrialTalk}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#IndustrialTalk">#IndustrialTalk</a>
	 */
	public static final URI IndustrialTalk;

	/**
	 * Industrial Track
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#IndustrialTrack}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TrackEvent">TrackEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#IndustrialTrack">#IndustrialTrack</a>
	 */
	public static final URI IndustrialTrack;

	/**
	 * Industry Chair or In-Use Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#IndustryChair}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#TrackChair">TrackChair</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#IndustryChair">#IndustryChair</a>
	 */
	public static final URI IndustryChair;

	/**
	 * Invited Paper
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#InvitedPaper}.
	 * <p>
	 * <p>As opposed to a peer-reviewed paper. This class has been deprecated
	 * in order to reduce the inflation of classes.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#InvitedPaper">#InvitedPaper</a>
	 */
	public static final URI InvitedPaper;

	/**
	 * is location of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isLocationFor}.
	 * <p>
	 * <p> Relates a location to a conference or sub-event thereof which
	 * takes place at it. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isLocationFor">#isLocationFor</a>
	 */
	public static final URI isLocationFor;

	/**
	 * is part of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isPartOf}.
	 * <p>
	 * <p> A generic property to model part-of relationships. In SWC this
	 * property is used to relate papers or articles to the <a
	 * href="#Proceedings">proceedings document</a> in which they are
	 * contained. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isPartOf">#isPartOf</a>
	 */
	public static final URI isPartOf;

	/**
	 * is provided by
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isProvidedBy}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isProvidedBy">#isProvidedBy</a>
	 */
	public static final URI isProvidedBy;

	/**
	 * is provider of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isProviderOf}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isProviderOf">#isProviderOf</a>
	 */
	public static final URI isProviderOf;

	/**
	 * is role at
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isRoleAt}.
	 * <p>
	 * <p> Part of the <a href="#Role">role</a> modelling machinery of SWC.
	 * This property relates a role at an event (e.g. a conference chair) to
	 * the event (e.g. a conference). </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isRoleAt">#isRoleAt</a>
	 */
	public static final URI isRoleAt;

	/**
	 * is a sub-event of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isSubEventOf}.
	 * <p>
	 * Events can be sub-events of other events. E.g., a talk can be a
	 * sub-event of a session, which in turn can be a sub-event of a
	 * conference. The relation is transitive - the talk is also a sub-event
	 * of the conference.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isSubEventOf">#isSubEventOf</a>
	 */
	public static final URI isSubEventOf;

	/**
	 * is the super-event of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isSuperEventOf}.
	 * <p>
	 * Events can be super-events of other events. E.g., a conference can be
	 * the super-event of a session, which in turn can be the super-event of
	 * a talk. The relation is transitive - the conference is also the
	 * super-event of the talk.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isSuperEventOf">#isSuperEventOf</a>
	 */
	public static final URI isSuperEventOf;

	/**
	 * is topic of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#isTopicOf}.
	 * <p>
	 * <p>Deprecated, instead using terms from FOAF.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#isTopicOf">#isTopicOf</a>
	 */
	public static final URI isTopicOf;

	/**
	 * Keynote Talk
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#KeynoteTalk}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#KeynoteTalk">#KeynoteTalk</a>
	 */
	public static final URI KeynoteTalk;

	/**
	 * License Statement
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#license_doc}.
	 * <p>
	 * <!-- Creative Commons License --> <p class="copyright"> Copyright
	 * &copy; 2007-2009 Knud Möller, Sean Bechhofer and Tom Heath.<br/> <br/>
	 * <a href="http://creativecommons.org/licenses/by/3.0/"><img
	 * alt="Creative Commons License" style="border: 0; float: right;
	 * padding: 10px;" src="somerights.gif" /></a> This work is licensed
	 * under a <a href="http://creativecommons.org/licenses/by/3.0/">Creative
	 * Commons Attribution License</a>. This copyright applies to the
	 * <em>Semantic Web Conference Ontology (SWC) Specification</em> and
	 * accompanying documentation in RDF. Regarding underlying technology,
	 * SWC uses W3C's <a href="http://www.w3.org/RDF/">RDF</a> technology, an
	 * open Web standard that can be freely used by anyone. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#license_doc">#license_doc</a>
	 */
	public static final URI license_doc;

	/**
	 * Local Organiser
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#LocalOrganiser}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#LocalOrganiser">#LocalOrganiser</a>
	 */
	public static final URI LocalOrganiser;

	/**
	 * Meal Break
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#MealBreak}.
	 * <p>
	 * Deprecating this - we can just use <a
	 * href="#BreakEvent">BreakEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#MealBreak">#MealBreak</a>
	 */
	public static final URI MealBreak;

	/**
	 * Meal Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#MealEvent}.
	 * <p>
	 * <p> A lunch, dinner or similar event at a conference or
	 * conference-like event. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#MealEvent">#MealEvent</a>
	 */
	public static final URI MealEvent;

	/**
	 * Meeting Room Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#MeetingRoomPlace}.
	 * <p>
	 * <p> A particular room at the <a
	 * href="#ConferenceVenuePlace">conference venue</a> (or elsewhere).
	 * E.g., the room where a particular <a
	 * href="#SessionEvent">SessionEvent</a> takes place. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#MeetingRoomPlace">#MeetingRoomPlace</a>
	 */
	public static final URI MeetingRoomPlace;

	/**
	 * member of
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#memberOf}.
	 * <p>
	 * <p>FOAF does not define an inverse of <code>foaf:member</code>, so SWC
	 * does it.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#memberOf">#memberOf</a>
	 */
	public static final URI memberOf;

	/**
	 * Non-academic Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#NonAcademicEvent}.
	 * <p>
	 * <p> In the context of SWC, a non-academic event is any kind or <a
	 * href="#OrganisedEvent">organised event</a> which does not concern the
	 * topic or theme of the conference as such. Examples are breaks,
	 * dinners, parties, etc. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#NonAcademicEvent">#NonAcademicEvent</a>
	 */
	public static final URI NonAcademicEvent;

	/**
	 * Organised Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#OrganisedEvent}.
	 * <p>
	 * <p>An event in time and space which is planned and organised, as
	 * opposed to something which 'just happens', such as a car accident or
	 * sunset.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#OrganisedEvent">#OrganisedEvent</a>
	 */
	public static final URI OrganisedEvent;

	/**
	 * Organising Committee Member
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#OrganisingCommitteeMember}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#OrganisingCommitteeMember">#OrganisingCommitteeMember</a>
	 */
	public static final URI OrganisingCommitteeMember;

	/**
	 * Panel Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PanelEvent}.
	 * <p>
	 * <p>A panel discussion at a conference or conference-like event,
	 * usually involving several speakers.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PanelEvent">#PanelEvent</a>
	 */
	public static final URI PanelEvent;

	/**
	 * Paper
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Paper}.
	 * <p>
	 * <p>A scientific/scholarly paper, e.g., an article in a scientific
	 * journal, or a paper at a conference or workshop. A paper could also be
	 * unpublished formally, as long as it has the form of a scientific paper
	 * (introduction, conclusion, related work, etc.).</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Paper">#Paper</a>
	 */
	public static final URI Paper;

	/**
	 * Paper Presentation
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PaperPresentation}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PaperPresentation">#PaperPresentation</a>
	 */
	public static final URI PaperPresentation;

	/**
	 * Paper Session
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PaperSession}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#SessionEvent">SessionEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PaperSession">#PaperSession</a>
	 */
	public static final URI PaperSession;

	/**
	 * PhD Symposium or Doctoral Consortium Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PhDSymposiumChair}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#TrackChair">TrackChair</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PhDSymposiumChair">#PhDSymposiumChair</a>
	 */
	public static final URI PhDSymposiumChair;

	/**
	 * Place
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Place}.
	 * <p>
	 * <p> Deprecated: no real need to have an internal super-class for
	 * locations, we can just use the <a
	 * href="&geo;SpatialThing">SpatialThing</a>. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Place">#Place</a>
	 */
	public static final URI Place;

	/**
	 * plans to attend
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#plansToAttend}.
	 * <p>
	 * <p> A person might plan to attend a talk or session at a conference or
	 * similar event. This property could be used to prepare a delegate's
	 * conference experience with respect to who they want to meet, etc. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#plansToAttend">#plansToAttend</a>
	 */
	public static final URI plansToAttend;

	/**
	 * Poster
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Poster}.
	 * <p>
	 * <p>A scientific poster at a conference or workshop.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Poster">#Poster</a>
	 */
	public static final URI Poster;

	/**
	 * Poster Presentation
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PosterPresentation}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PosterPresentation">#PosterPresentation</a>
	 */
	public static final URI PosterPresentation;

	/**
	 * Posters Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PostersChair}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#TrackChair">TrackChair</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PostersChair">#PostersChair</a>
	 */
	public static final URI PostersChair;

	/**
	 * Poster Session
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PosterSession}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#SessionEvent">SessionEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PosterSession">#PosterSession</a>
	 */
	public static final URI PosterSession;

	/**
	 * Presenter
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Presenter}.
	 * <p>
	 * <p> A presenter is someone who presents matter in front of an
	 * audience. Examples of events to which this role applies are paper
	 * presentations, tutorials, or talks. A keynote speaker could also be
	 * modelled as an instance of this class. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Presenter">#Presenter</a>
	 */
	public static final URI Presenter;

	/**
	 * (Printed) Proceedings Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PrintedProceedingsChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PrintedProceedingsChair">#PrintedProceedingsChair</a>
	 */
	public static final URI PrintedProceedingsChair;

	/**
	 * Proceedings
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Proceedings}.
	 * <p>
	 * <p>The proceedings of a conference or workshop, which contain the
	 * papers presented there.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Proceedings">#Proceedings</a>
	 */
	public static final URI Proceedings;

	/**
	 * Programme
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Programme}.
	 * <p>
	 * <p>A document containing the programme of an event such as a
	 * conference or workshop. Typically, the programme would list the times
	 * and dates for the individual sub-events, e.g., talks, dinners, panel
	 * discussions, etc.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Programme">#Programme</a>
	 */
	public static final URI Programme;

	/**
	 * Programme Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ProgrammeChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ProgrammeChair">#ProgrammeChair</a>
	 */
	public static final URI ProgrammeChair;

	/**
	 * Programme Committee Member
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ProgrammeCommitteeMember}.
	 * <p>
	 * <p> This role is played by the members of the programme committee of a
	 * conference or conference-like event. We found this role to be so
	 * significant that it justifies to be represented by its own class. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ProgrammeCommitteeMember">#ProgrammeCommitteeMember</a>
	 */
	public static final URI ProgrammeCommitteeMember;

	/**
	 * Publicity Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#PublicityChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#PublicityChair">#PublicityChair</a>
	 */
	public static final URI PublicityChair;

	/**
	 * Reception
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Reception}.
	 * <p>
	 * Deprecating this - we can just use <a
	 * href="#SocialEvent">SocialEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Reception">#Reception</a>
	 */
	public static final URI Reception;

	/**
	 * related to Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#relatedToEvent}.
	 * <p>
	 * <p> Relates a <a href="#ArgumentativeDocument">document</a> to an <a
	 * href="#AcademicEvent">event</a> such as a conference, workshop, etc.
	 * </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#relatedToEvent">#relatedToEvent</a>
	 */
	public static final URI relatedToEvent;

	/**
	 * Research Track
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#ResearchTrack}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TrackEvent">TrackEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#ResearchTrack">#ResearchTrack</a>
	 */
	public static final URI ResearchTrack;

	/**
	 * Reviewer
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Reviewer}.
	 * <p>
	 * <p> Deprecating this, just use <a
	 * href="#ProgrammeCommitteeMember">ProgrammeCommitteeMember</a> instead.
	 * </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Reviewer">#Reviewer</a>
	 */
	public static final URI Reviewer;

	/**
	 * Role
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Role}.
	 * <p>
	 * <p> Role is the super-class of all the different roles performed at a
	 * conference or workshop. Examples are the various conference chairs,
	 * the delegates, presenters, PC members, etc. The intended use of this
	 * class is that an instance of Role will be related to the event at
	 * which it is performed, and to the person which performs it. </p> <p>
	 * Since the set of roles is slightly different for each event, and since
	 * it would therefore be impossible to provide sub-classes for all needs
	 * and circumstances, the SWC ontology only contains a very basic set of
	 * Role classes. Rather than diversifying the set of Role classes to
	 * cater for all needs, users should instead instantiate the small set of
	 * different Role classes and cover the roles at a specific event in this
	 * way. E.g., instead of sub-classing the Chair role with MainChair,
	 * WorkshopChair, TutorialChair, etc., the different kinds of chairs
	 * should simply be instances of the generic Chair class and be labelled
	 * appropriately. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Role">#Role</a>
	 */
	public static final URI Role;

	/**
	 * Session Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SessionChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SessionChair">#SessionChair</a>
	 */
	public static final URI SessionChair;

	/**
	 * Session Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SessionEvent}.
	 * <p>
	 * <p> A session dedicated to a specific topic at a conference. This
	 * could be a session with talks, or also a poster session, a demo
	 * session, or any other kind of session. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SessionEvent">#SessionEvent</a>
	 */
	public static final URI SessionEvent;

	/**
	 * Slide Set
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SlideSet}.
	 * <p>
	 * <p>A set of slides used for a presentation of e.g. a paper at a
	 * conference.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SlideSet">#SlideSet</a>
	 */
	public static final URI SlideSet;

	/**
	 * Social Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SocialEvent}.
	 * <p>
	 * <p> Examples for social events are parties or excursions. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SocialEvent">#SocialEvent</a>
	 */
	public static final URI SocialEvent;

	/**
	 * Sponsorship
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Sponsorship}.
	 * <p>
	 * <p>Deprecated because it has never been used and in order to reduce
	 * the inflation of ontology terms.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Sponsorship">#Sponsorship</a>
	 */
	public static final URI Sponsorship;

	/**
	 * Sponsorship Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SponsorshipChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SponsorshipChair">#SponsorshipChair</a>
	 */
	public static final URI SponsorshipChair;

	/**
	 * Submissions Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SubmissionsChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SubmissionsChair">#SubmissionsChair</a>
	 */
	public static final URI SubmissionsChair;

	/**
	 * Semantic Web Challenge Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SWChallengeChair}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#TrackChair">TrackChair</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SWChallengeChair">#SWChallengeChair</a>
	 */
	public static final URI SWChallengeChair;

	/**
	 * System Demonstration
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SystemDemonstration}.
	 * <p>
	 * <p>A type of paper which accompanies the demonstration of software,
	 * also known as an extended abstract or demo description. This class has
	 * been deprecated in order to reduce the inflation of classes; it is too
	 * specific for CS conferences.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SystemDemonstration">#SystemDemonstration</a>
	 */
	public static final URI SystemDemonstration;

	/**
	 * System Description
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#SystemDescription}.
	 * <p>
	 * <p> A type of paper which is mainly describes the properties,
	 * implementation or architecture of an system (such as a software
	 * system). </p> <p> Deprecating this: it's too specific for, not generic
	 * enough to apply for most conferences.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#SystemDescription">#SystemDescription</a>
	 */
	public static final URI SystemDescription;

	/**
	 * Talk Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#TalkEvent}.
	 * <p>
	 * <p> A speaker giving a talk. This could be the presentation of a
	 * paper, but also keynote speech or any other kind of talk. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#TalkEvent">#TalkEvent</a>
	 */
	public static final URI TalkEvent;

	/**
	 * Track Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#TrackChair}.
	 * <p>
	 * <p> The chair of a particular track of a conference, responsible for
	 * all submissions and actions regarding this track. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#TrackChair">#TrackChair</a>
	 */
	public static final URI TrackChair;

	/**
	 * Track Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#TrackEvent}.
	 * <p>
	 * <p> A track groups all those sessions or events at a conference or
	 * workshop that belong to a common, overall theme. Depending on the
	 * conference, tracks can be quite generic, such as "Research" or
	 * "Industrial", but can also be more specific, such as "Semantic Web" or
	 * "Numismatics". SWC does not define any specific tracks, since
	 * conferences often differ so much with respect to how they structure
	 * their tracks, that it would be pointless to try and find a set of
	 * tracks that would suit all conferences. </p> <p>Sub-classes of
	 * TrackEvent which were defined in previous versions of the SWC ontology
	 * are now deprecated.</p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#TrackEvent">#TrackEvent</a>
	 */
	public static final URI TrackEvent;

	/**
	 * Treasurer
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Treasurer}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Treasurer">#Treasurer</a>
	 */
	public static final URI Treasurer;

	/**
	 * Tutor
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Tutor}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Tutor">#Tutor</a>
	 */
	public static final URI Tutor;

	/**
	 * Tutorial Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#TutorialEvent}.
	 * <p>
	 * <p> A tutorial is a special session at a conference or workshop,
	 * somewhat like a long lecture on a specific topic. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#TutorialEvent">#TutorialEvent</a>
	 */
	public static final URI TutorialEvent;

	/**
	 * Tutorial Presenter
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#TutorialPresenter}.
	 * <p>
	 * <p> Deprecating this, just use <a href="#Presenter">Presenter</a>
	 * instead. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#TutorialPresenter">#TutorialPresenter</a>
	 */
	public static final URI TutorialPresenter;

	/**
	 * Tutorials Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#TutorialsChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#TutorialsChair">#TutorialsChair</a>
	 */
	public static final URI TutorialsChair;

	/**
	 * uuid
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#uuid}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#uuid">#uuid</a>
	 */
	public static final URI uuid;

	/**
	 * Webmaster
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#Webmaster}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#Webmaster">#Webmaster</a>
	 */
	public static final URI Webmaster;

	/**
	 * Welcome Talk
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#WelcomeTalk}.
	 * <p>
	 * Deprecating this - we can just as well use <a
	 * href="#TalkEvent">TalkEvent</a>.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#WelcomeTalk">#WelcomeTalk</a>
	 */
	public static final URI WelcomeTalk;

	/**
	 * Workshop Event
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#WorkshopEvent}.
	 * <p>
	 * <p> A scientific workshop. Workshops are often co-located with <a
	 * href="#ConferenceEvent">ConferenceEvent</a>s. </p>
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#WorkshopEvent">#WorkshopEvent</a>
	 */
	public static final URI WorkshopEvent;

	/**
	 * Workshop Organiser
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#WorkshopOrganiser}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#WorkshopOrganiser">#WorkshopOrganiser</a>
	 */
	public static final URI WorkshopOrganiser;

	/**
	 * Workshops Chair
	 * <p>
	 * {@code http://data.semanticweb.org/ns/swc/ontology#WorkshopsChair}.
	 *
	 * @see <a href="http://data.semanticweb.org/ns/swc/ontology#WorkshopsChair">#WorkshopsChair</a>
	 */
	public static final URI WorkshopsChair;

	static {
		ValueFactory factory = ValueFactoryImpl.getInstance();

		x01_introduction = factory.createURI(SWC.NAMESPACE, "#01_introduction");
		x02_describing_papers = factory.createURI(SWC.NAMESPACE, "#02_describing_papers");
		x03_roles = factory.createURI(SWC.NAMESPACE, "#03_roles");
		AcademicEvent = factory.createURI(SWC.NAMESPACE, "#AcademicEvent");
		AccommodationPlace = factory.createURI(SWC.NAMESPACE, "#AccommodationPlace");
		AdditionalReviewer = factory.createURI(SWC.NAMESPACE, "#AdditionalReviewer");
		Administrator = factory.createURI(SWC.NAMESPACE, "#Administrator");
		affiliation = factory.createURI(SWC.NAMESPACE, "#affiliation");
		ArgumentativeDocument = factory.createURI(SWC.NAMESPACE, "#ArgumentativeDocument");
		Artefact = factory.createURI(SWC.NAMESPACE, "#Artefact");
		attendeeAt = factory.createURI(SWC.NAMESPACE, "#attendeeAt");
		biblioReference = factory.createURI(SWC.NAMESPACE, "#biblioReference");
		BreakEvent = factory.createURI(SWC.NAMESPACE, "#BreakEvent");
		Call = factory.createURI(SWC.NAMESPACE, "#Call");
		CallForDemos = factory.createURI(SWC.NAMESPACE, "#CallForDemos");
		CallForPapers = factory.createURI(SWC.NAMESPACE, "#CallForPapers");
		CallForParticipation = factory.createURI(SWC.NAMESPACE, "#CallForParticipation");
		CallForPosters = factory.createURI(SWC.NAMESPACE, "#CallForPosters");
		CallForProposals = factory.createURI(SWC.NAMESPACE, "#CallForProposals");
		Chair = factory.createURI(SWC.NAMESPACE, "#Chair");
		CoffeeBreak = factory.createURI(SWC.NAMESPACE, "#CoffeeBreak");
		CommunalPlace = factory.createURI(SWC.NAMESPACE, "#CommunalPlace");
		ConferenceChair = factory.createURI(SWC.NAMESPACE, "#ConferenceChair");
		ConferenceClosingEvent = factory.createURI(SWC.NAMESPACE, "#ConferenceClosingEvent");
		ConferenceDinner = factory.createURI(SWC.NAMESPACE, "#ConferenceDinner");
		ConferenceEvent = factory.createURI(SWC.NAMESPACE, "#ConferenceEvent");
		ConferenceOpeningEvent = factory.createURI(SWC.NAMESPACE, "#ConferenceOpeningEvent");
		ConferenceVenuePlace = factory.createURI(SWC.NAMESPACE, "#ConferenceVenuePlace");
		Delegate = factory.createURI(SWC.NAMESPACE, "#Delegate");
		DemoPresentation = factory.createURI(SWC.NAMESPACE, "#DemoPresentation");
		DemosChair = factory.createURI(SWC.NAMESPACE, "#DemosChair");
		DemoSession = factory.createURI(SWC.NAMESPACE, "#DemoSession");
		DogfoodTsar = factory.createURI(SWC.NAMESPACE, "#DogfoodTsar");
		DrinkingPlace = factory.createURI(SWC.NAMESPACE, "#DrinkingPlace");
		EatingPlace = factory.createURI(SWC.NAMESPACE, "#EatingPlace");
		Excursion = factory.createURI(SWC.NAMESPACE, "#Excursion");
		ExhibitionChair = factory.createURI(SWC.NAMESPACE, "#ExhibitionChair");
		forEvent = factory.createURI(SWC.NAMESPACE, "#forEvent");
		FreeTimeBreak = factory.createURI(SWC.NAMESPACE, "#FreeTimeBreak");
		hasAttendee = factory.createURI(SWC.NAMESPACE, "#hasAttendee");
		hasCall = factory.createURI(SWC.NAMESPACE, "#hasCall");
		hasCameraReadyDeadline = factory.createURI(SWC.NAMESPACE, "#hasCameraReadyDeadline");
		hasCostAmount = factory.createURI(SWC.NAMESPACE, "#hasCostAmount");
		hasCostCurrency = factory.createURI(SWC.NAMESPACE, "#hasCostCurrency");
		hasLocation = factory.createURI(SWC.NAMESPACE, "#hasLocation");
		hasMenu = factory.createURI(SWC.NAMESPACE, "#hasMenu");
		hasNotificationDeadline = factory.createURI(SWC.NAMESPACE, "#hasNotificationDeadline");
		hasPart = factory.createURI(SWC.NAMESPACE, "#hasPart");
		hasProgramme = factory.createURI(SWC.NAMESPACE, "#hasProgramme");
		hasRelatedArtefact = factory.createURI(SWC.NAMESPACE, "#hasRelatedArtefact");
		hasRelatedDocument = factory.createURI(SWC.NAMESPACE, "#hasRelatedDocument");
		hasRole = factory.createURI(SWC.NAMESPACE, "#hasRole");
		hasSponsorship = factory.createURI(SWC.NAMESPACE, "#hasSponsorship");
		hasSubmissionDeadline = factory.createURI(SWC.NAMESPACE, "#hasSubmissionDeadline");
		hasSubmissionInstructions = factory.createURI(SWC.NAMESPACE, "#hasSubmissionInstructions");
		hasTopic = factory.createURI(SWC.NAMESPACE, "#hasTopic");
		heldBy = factory.createURI(SWC.NAMESPACE, "#heldBy");
		holdsRole = factory.createURI(SWC.NAMESPACE, "#holdsRole");
		IndustrialTalk = factory.createURI(SWC.NAMESPACE, "#IndustrialTalk");
		IndustrialTrack = factory.createURI(SWC.NAMESPACE, "#IndustrialTrack");
		IndustryChair = factory.createURI(SWC.NAMESPACE, "#IndustryChair");
		InvitedPaper = factory.createURI(SWC.NAMESPACE, "#InvitedPaper");
		isLocationFor = factory.createURI(SWC.NAMESPACE, "#isLocationFor");
		isPartOf = factory.createURI(SWC.NAMESPACE, "#isPartOf");
		isProvidedBy = factory.createURI(SWC.NAMESPACE, "#isProvidedBy");
		isProviderOf = factory.createURI(SWC.NAMESPACE, "#isProviderOf");
		isRoleAt = factory.createURI(SWC.NAMESPACE, "#isRoleAt");
		isSubEventOf = factory.createURI(SWC.NAMESPACE, "#isSubEventOf");
		isSuperEventOf = factory.createURI(SWC.NAMESPACE, "#isSuperEventOf");
		isTopicOf = factory.createURI(SWC.NAMESPACE, "#isTopicOf");
		KeynoteTalk = factory.createURI(SWC.NAMESPACE, "#KeynoteTalk");
		license_doc = factory.createURI(SWC.NAMESPACE, "#license_doc");
		LocalOrganiser = factory.createURI(SWC.NAMESPACE, "#LocalOrganiser");
		MealBreak = factory.createURI(SWC.NAMESPACE, "#MealBreak");
		MealEvent = factory.createURI(SWC.NAMESPACE, "#MealEvent");
		MeetingRoomPlace = factory.createURI(SWC.NAMESPACE, "#MeetingRoomPlace");
		memberOf = factory.createURI(SWC.NAMESPACE, "#memberOf");
		NonAcademicEvent = factory.createURI(SWC.NAMESPACE, "#NonAcademicEvent");
		OrganisedEvent = factory.createURI(SWC.NAMESPACE, "#OrganisedEvent");
		OrganisingCommitteeMember = factory.createURI(SWC.NAMESPACE, "#OrganisingCommitteeMember");
		PanelEvent = factory.createURI(SWC.NAMESPACE, "#PanelEvent");
		Paper = factory.createURI(SWC.NAMESPACE, "#Paper");
		PaperPresentation = factory.createURI(SWC.NAMESPACE, "#PaperPresentation");
		PaperSession = factory.createURI(SWC.NAMESPACE, "#PaperSession");
		PhDSymposiumChair = factory.createURI(SWC.NAMESPACE, "#PhDSymposiumChair");
		Place = factory.createURI(SWC.NAMESPACE, "#Place");
		plansToAttend = factory.createURI(SWC.NAMESPACE, "#plansToAttend");
		Poster = factory.createURI(SWC.NAMESPACE, "#Poster");
		PosterPresentation = factory.createURI(SWC.NAMESPACE, "#PosterPresentation");
		PostersChair = factory.createURI(SWC.NAMESPACE, "#PostersChair");
		PosterSession = factory.createURI(SWC.NAMESPACE, "#PosterSession");
		Presenter = factory.createURI(SWC.NAMESPACE, "#Presenter");
		PrintedProceedingsChair = factory.createURI(SWC.NAMESPACE, "#PrintedProceedingsChair");
		Proceedings = factory.createURI(SWC.NAMESPACE, "#Proceedings");
		Programme = factory.createURI(SWC.NAMESPACE, "#Programme");
		ProgrammeChair = factory.createURI(SWC.NAMESPACE, "#ProgrammeChair");
		ProgrammeCommitteeMember = factory.createURI(SWC.NAMESPACE, "#ProgrammeCommitteeMember");
		PublicityChair = factory.createURI(SWC.NAMESPACE, "#PublicityChair");
		Reception = factory.createURI(SWC.NAMESPACE, "#Reception");
		relatedToEvent = factory.createURI(SWC.NAMESPACE, "#relatedToEvent");
		ResearchTrack = factory.createURI(SWC.NAMESPACE, "#ResearchTrack");
		Reviewer = factory.createURI(SWC.NAMESPACE, "#Reviewer");
		Role = factory.createURI(SWC.NAMESPACE, "#Role");
		SessionChair = factory.createURI(SWC.NAMESPACE, "#SessionChair");
		SessionEvent = factory.createURI(SWC.NAMESPACE, "#SessionEvent");
		SlideSet = factory.createURI(SWC.NAMESPACE, "#SlideSet");
		SocialEvent = factory.createURI(SWC.NAMESPACE, "#SocialEvent");
		Sponsorship = factory.createURI(SWC.NAMESPACE, "#Sponsorship");
		SponsorshipChair = factory.createURI(SWC.NAMESPACE, "#SponsorshipChair");
		SubmissionsChair = factory.createURI(SWC.NAMESPACE, "#SubmissionsChair");
		SWChallengeChair = factory.createURI(SWC.NAMESPACE, "#SWChallengeChair");
		SystemDemonstration = factory.createURI(SWC.NAMESPACE, "#SystemDemonstration");
		SystemDescription = factory.createURI(SWC.NAMESPACE, "#SystemDescription");
		TalkEvent = factory.createURI(SWC.NAMESPACE, "#TalkEvent");
		TrackChair = factory.createURI(SWC.NAMESPACE, "#TrackChair");
		TrackEvent = factory.createURI(SWC.NAMESPACE, "#TrackEvent");
		Treasurer = factory.createURI(SWC.NAMESPACE, "#Treasurer");
		Tutor = factory.createURI(SWC.NAMESPACE, "#Tutor");
		TutorialEvent = factory.createURI(SWC.NAMESPACE, "#TutorialEvent");
		TutorialPresenter = factory.createURI(SWC.NAMESPACE, "#TutorialPresenter");
		TutorialsChair = factory.createURI(SWC.NAMESPACE, "#TutorialsChair");
		uuid = factory.createURI(SWC.NAMESPACE, "#uuid");
		Webmaster = factory.createURI(SWC.NAMESPACE, "#Webmaster");
		WelcomeTalk = factory.createURI(SWC.NAMESPACE, "#WelcomeTalk");
		WorkshopEvent = factory.createURI(SWC.NAMESPACE, "#WorkshopEvent");
		WorkshopOrganiser = factory.createURI(SWC.NAMESPACE, "#WorkshopOrganiser");
		WorkshopsChair = factory.createURI(SWC.NAMESPACE, "#WorkshopsChair");
	}

	private SWC() {
		//static access only
	}

}
