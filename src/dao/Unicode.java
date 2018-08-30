package dao;

public class Unicode {
	public static String pat=   
            /*"[\u4E00-\u9FBF]|"+//��CJK ͳһ������� (CJK Unified Ideographs)  
            "[\u4DC0-\u4DFF]|"+//���׾���ʮ���Է��� (Yijing Hexagrams Symbols)*/  
            "[\u0000-\u007F]|"+//��C0���Ʒ������������� (C0 Control and Basic Latin)  
            "[\u0080-\u00FF]|"+//��C1���Ʒ�������������-1 (C1 Control and Latin 1 Supplement)  
            "[\u0100-\u017F]|"+//����������չ-A (Latin Extended-A)  
            "[\u0180-\u024F]|"+//����������չ-B (Latin Extended-B)  
            "[\u0250-\u02AF]|"+//������������չ (IPA Extensions)  
            "[\u02B0-\u02FF]|"+//���հ�������ĸ (Spacing Modifiers)  
            "[\u0300-\u036F]|"+//������ö������� (Combining Diacritics Marks)  
            "[\u0370-\u03FF]|"+//��ϣ���ļ��������� (Greek and Coptic)  
            "[\u0400-\u04FF]|"+//���������ĸ (Cyrillic)  
            "[\u0500-\u052F]|"+//���������ĸ���� (Cyrillic Supplement)  
            "[\u0530-\u058F]|"+//������������ (Armenian)  
            "[\u0590-\u05FF]|"+//��ϣ������ (Hebrew)  
            "[\u0600-\u06FF]|"+//���������� (Arabic)  
            "[\u0700-\u074F]|"+//���������� (Syriac)  
            "[\u0750-\u077F]|"+//���������Ĳ��� (Arabic Supplement)  
            "[\u0780-\u07BF]|"+//����������� (Thaana)  
            //"\u07C0-\u077F"+//�������������� (N'Ko)  
            "[\u0800-\u085F]|"+//����ά˹���Ｐ����ά�� (Avestan and Pahlavi)  
            "[\u0860-\u087F]|"+//��Mandaic  
            "[\u0880-\u08AF]|"+//������������ (Samaritan)  
            "[\u0900-\u097F]|"+//��������� (Devanagari)  
            "[\u0980-\u09FF]|"+//���ϼ����� (Bengali)  
            "[\u0A00-\u0A7F]|"+//�����˽��� (Gurmukhi)  
            "[\u0A80-\u0AFF]|"+//���ż������� (Gujarati)  
            "[\u0B00-\u0B7F]|"+//���������� (Oriya)  
            "[\u0B80-\u0BFF]|"+//��̩�׶��� (Tamil)  
            "[\u0C00-\u0C7F]|"+//��̩¬���� (Telugu)  
            "[\u0C80-\u0CFF]|"+//�����ɴ��� (Kannada)  
            "[\u0D00-\u0D7F]|"+//������ά���� (Malayalam)  
            "[\u0D80-\u0DFF]|"+//��ɮ٤���� (Sinhala)  
            "[\u0E00-\u0E7F]|"+//��̩�� (Thai)  
            "[\u0E80-\u0EFF]|"+//�������� (Lao)  
            "[\u0F00-\u0FFF]|"+//������ (Tibetan)  
            "[\u1000-\u109F]|"+//������� (Myanmar)  
            "[\u10A0-\u10FF]|"+//����³������ (Georgian)  
            "[\u1100-\u11FF]|"+//�������� (Hangul Jamo)  
            "[\u1200-\u137F]|"+//������������� (Ethiopic)  
            "[\u1380-\u139F]|"+//������������ﲹ�� (Ethiopic Supplement)  
            "[\u13A0-\u13FF]|"+//�����޻��� (Cherokee)  
            "[\u1400-\u167F]|"+//��ͳһ���ô����������� (Unified Canadian Aboriginal Syllabics)  
            "[\u1680-\u169F]|"+//��ŷ����ĸ (Ogham)  
            "[\u16A0-\u16FF]|"+//�������� (Runic)  
            "[\u1700-\u171F]|"+//���������� (Tagalog)  
            "[\u1720-\u173F]|"+//��Hanun��o  
            "[\u1740-\u175F]|"+//��Buhid  
            "[\u1760-\u177F]|"+//��Tagbanwa  
            "[\u1780-\u17FF]|"+//�������� (Khmer)  
            "[\u1800-\u18AF]|"+//���ɹ��� (Mongolian)  
            "[\u18B0-\u18FF]|"+//��Cham  
            "[\u1900-\u194F]|"+//��Limbu  
            "[\u1950-\u197F]|"+//���º�̩�� (Tai Le)  
            "[\u1980-\u19DF]|"+//���´����� (New Tai Lue)  
            "[\u19E0-\u19FF]|"+//��������Ǻ� (Kmer Symbols)  
            "[\u1A00-\u1A1F]|"+//��Buginese  
            "[\u1A20-\u1A5F]|"+//��Batak  
            "[\u1A80-\u1AEF]|"+//��Lanna  
            "[\u1B00-\u1B7F]|"+//�������� (Balinese)  
            "[\u1B80-\u1BB0]|"+//�������� (Sundanese)  
            "[\u1BC0-\u1BFF]|"+//��Pahawh Hmong  
            "[\u1C00-\u1C4F]|"+//���ײ�����(Lepcha)  
            "[\u1C50-\u1C7F]|"+//��Ol Chiki  
            "[\u1C80-\u1CDF]|"+//�������ն��� (Meithei/Manipuri)  
            "[\u1D00-\u1D7F]|"+//������ѧ��չ (Phone tic Extensions)  
            /*"[\u1D80-\u1DBF]|"+//������ѧ��չ���� (Phonetic Extensions Supplement)  */
            "[\u1DC0-\u1DFF]|"+//����ö������Ų��� (Combining Diacritics Marks Supplement)  
            "[\u1E00-\u1EFF]|"+//�����������丽�� (Latin Extended Additional)  
            "[\u1F00-\u1FFF]|"+//��ϣ�������� (Greek Extended)  
            "[\u2000-\u206F]|"+//�����ñ�� (General Punctuation)  
            "[\u2070-\u209F]|"+//���ϱ꼰�±� (Superscripts and Subscripts)  
            "[\u20A0-\u20CF]|"+//�����ҷ��� (Currency Symbols)  
            "[\u20D0-\u20FF]|"+//������üǺ� (Combining Diacritics Marks for Symbols)  
            "[\u2100-\u214F]|"+//����ĸʽ���� (Letterlike Symbols)  
            "[\u2150-\u218F]|"+//��������ʽ (Number Form)  
            "[\u2190-\u21FF]|"+//����ͷ (Arrows)  
            "[\u2200-\u22FF]|"+//����ѧ����� (Mathematical Operator)  
            "[\u2300-\u23FF]|"+//�����ҵ���� (Miscellaneous Technical)  
            "[\u2400-\u243F]|"+//������ͼƬ (Control Pictures)  
            "[\u2440-\u245F]|"+//����ѧʶ��� (Optical Character Recognition)  
            "[\u2460-\u24FF]|"+//�����ʽ��ĸ���� (Enclosed Alphanumerics)  
            "[\u2500-\u257F]|"+//���Ʊ�� (Box Drawing) 
            "[\u2580-\u259F]|"+//������Ԫ�� (Block Element)  
            "[\u25A0-\u25FF]|"+//������ͼ�� (Geometric Shapes)
            "[\u2600-\u26FF]|"+//��������� (Miscellaneous Symbols)  
            "[\u2700-\u27BF]|"+//��ӡˢ���� (Dingbats)  
            "[\u27C0-\u27EF]|"+//��������ѧ����-A (Miscellaneous Mathematical Symbols-A)  
            "[\u27F0-\u27FF]|"+//��׷�Ӽ�ͷ-A (Supplemental Arrows-A)  
            "[\u2800-\u28FF]|"+//��ä�ĵ���ģ�� (Braille Patterns)  
            "[\u2900-\u297F]|"+//��׷�Ӽ�ͷ-B (Supplemental Arrows-B)  
            "[\u2980-\u29FF]|"+//��������ѧ����-B (Miscellaneous Mathematical Symbols-B)  
            "[\u2A00-\u2AFF]|"+//��׷����ѧ����� (Supplemental Mathematical Operator)  
            "[\u2B00-\u2BFF]|"+//��������źͼ�ͷ (Miscellaneous Symbols and Arrows)  
            //"[\u2C00-\u2C5F]|"+//������������ĸ (Glagolitic)  */
            "[\u2C60-\u2C7F]|"+//����������չ-C (Latin Extended-C)  
            "[\u2C80-\u2CFF]|"+//���Ű����� (Coptic)  
            "[\u2D00-\u2D2F]|"+//����³�����ﲹ�� (Georgian Supplement)  
            "[\u2D30-\u2D7F]|"+//��������� (Tifinagh)  
            "[\u2D80-\u2DDF]|"+//���������������չ (Ethiopic Extended)  
            "[\u2E00-\u2E7F]|"+//��׷�ӱ�� (Supplemental Punctuation)  
           /* "[\u2E80-\u2EFF]|"+//��CJK ���ײ��� (CJK Radicals Supplement)  ����*/
            "[\u2F00-\u2FDF]|"+//�������ֵ䲿�� (Kangxi Radicals)  ����
            "[\u2FF0-\u2FFF]|"+//���������������� (Ideographic Description Characters)  ����
            "[\u3000-\u303F]|"+//��CJK ���źͱ�� (CJK Symbols and Punctuation)  ����
            "[\u3040-\u309F]|"+//������ƽ���� (Hiragana)  
            "[\u30A0-\u30FF]|"+//������Ƭ���� (Katakana)  
           /* "[\u3100-\u312F]|"+//��ע����ĸ (Bopomofo)  ����*/
            "[\u3130-\u318F]|"+//�������ļ�����ĸ (Hangul Compatibility Jamo)  
            "[\u3190-\u319F]|"+//��������ע�ͱ�־ (Kanbun)  
            /*"[\u31A0-\u31BF]|"+//��ע����ĸ��չ (Bopomofo Extended)  ����
            "[\u31C0-\u31EF]|"+//��CJK �ʻ� (CJK Strokes)  ����*/
            "[\u31F0-\u31FF]|"+//������Ƭ����������չ (Katakana Phonetic Extensions)  
            "[\u3200-\u32FF]|"+//�����ʽ CJK ���ֺ��·� (Enclosed CJK Letters and Months)  
            /*"[\u3300-\u33FF]|"+//��CJK ���� (CJK Compatibility)  */
            "[\u3400-\u4DBF]|"+//��CJK ͳһ���������չ A (CJK Unified Ideographs Extension A)  ����
            "[\u4DC0-\u4DFF]|"+//���׾���ʮ���Է��� (Yijing Hexagrams Symbols)  
            /*"[\u4E00-\u9FBF]|"+//��CJK ͳһ������� (CJK Unified Ideographs)���ú������򣬸��������ڡ�������ʽ��  ����*/
            "[\uA000-\uA48F]|"+//���������� (Yi Syllables)  
            "[\uA490-\uA4CF]|"+//�������ָ� (Yi Radicals)  
            "[\uA500-\uA61F]|"+//��Vai  
            "[\uA660-\uA6FF]|"+//��ͳһ���ô����������ڲ��� (Unified Canadian Aboriginal Syllabics Supplement)  
            /*"[\uA700-\uA71F]|"+//������������ĸ (Modifier Tone Letters)  */
            "[\uA720-\uA7FF]|"+//����������չ-D (Latin Extended-D)  
            /*"[\uA800-\uA82F]|"+//��Syloti Nagri  
            "[\uA840-\uA87F]|"+//����˼���� (Phags-pa)  
            "[\uA880-\uA8DF]|"+//��Saurashtra  
            "[\uA900-\uA97F]|"+//��צ���� (Javanese)  
            "[\uA980-\uA9DF]|"+//��Chakma  
            "[\uAA00-\uAA3F]|"+//��Varang Kshiti  
            "[\uAA40-\uAA6F]|"+//��Sorang Sompeng  
            "[\uAA80-\uAADF]|"+//��Newari  
            "[\uAB00-\uAB5F]|"+//��Խ�ϴ��� (Vi?t Th��i)  
            "[\uAB80-\uABA0]|"+//��Kayah Li*/  
            "[\uAC00-\uD7AF]|"+//������������ (Hangul Syllables)  
          /*  //"\uD800-\uDBFF"+//��High-half zone of UTF-16  
            //"\uDC00-\uDFFF"+//��Low-half zone of UTF-16  
            "[\uE000-\uF8FF]|"+//������ʹ������ (Private Use Zone)  ������
            "[\uF900-\uFAFF]|"+//��CJK ������������ (CJK Compatibility Ideographs)  ����*/
            "[\uFB00-\uFB4F]|"+//����ĸ�����ʽ (Alphabetic Presentation Form)  
            "[\uFB50-\uFDFF]|"+//�������������ʽA (Arabic Presentation Form-A)  
            "[\uFE00-\uFE0F]|"+//������ѡ��� (Variation Selector)  
            "[\uFE10-\uFE1F]|"+//��������ʽ (Vertical Forms)  
            "[\uFE20-\uFE2F]|"+//������ð���� (Combining Half Marks)  
            /*"[\uFE30-\uFE4F]|"+//��CJK ������ʽ (CJK Compatibility Forms)  */
            "[\uFE50-\uFE6F]|"+//��С�ͱ�����ʽ (Small Form Variants)  
            "[\uFE70-\uFEFF]|"+//�������������ʽB (Arabic Presentation Form-B) 
            "[\uFF00-\uFFEF]|"+ //+�����ͼ�ȫ����ʽ (Halfwidth and Fullwidth Form)  
            "[\uFFF0-\uFFFF]";//������ (Specials); */

}
