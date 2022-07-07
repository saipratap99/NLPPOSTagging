import epic.models.PosTagSelector
import epic.preprocess.{MLSentenceSegmenter, TreebankTokenizer}
import epic.sequences.CRF
import epic.trees.AnnotatedLabel

import scala.collection.immutable.IndexedSeq
import scala.io.Source

object Main extends Serializable {
  def main(args: Array[String]): Unit = {

  val text = Source.fromFile("/home/hadoop/smalltext.txt").getLines().mkString("\n");

    // sentence segmenter
    // segment out the sentence from the text
    val sentenceSplitter = MLSentenceSegmenter.bundled().get
    val tokenizer = new TreebankTokenizer()

    // tokenizing each wordS
    val sentences = sentenceSplitter(text).map(tokenizer).toIndexedSeq

    for(sentence <- sentences)
      println(sentence)


  }
}